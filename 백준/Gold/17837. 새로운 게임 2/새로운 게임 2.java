import java.io.*;
import java.util.*;
public class Main{
	
	static int[][] board;
	static int []dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static int N, K, cnt, ans;
	static List<int[]> horse; // 말의 위치, 방향 저장
	static List<Integer>[][] stackHorse; // 말이 해당 위치에 몇마리 있는지
	
	static void solve() {
		for(cnt = 1 ; cnt < 1000; cnt++) {
			for(int i = 1 ; i <= K; i++) {
				// horse는 0~K-1 까지 들어가있으므로 get(i-1) 로 접근
				int x = horse.get(i-1)[0];
				int y = horse.get(i-1)[1];
				int d = horse.get(i-1)[2];
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				// 범위밖 or 파랑
				if (nx <= 0 || nx > N || ny <= 0 || ny > N || board[nx][ny] == 2) {
					// 방향 설정
					if(d == 0 || d == 2) d++;
					else d--;
					nx = x + dx[d];
					ny = y + dy[d];
					horse.get(i-1)[2] = d; // 방향 갱신
				}
				// 이후 이동은 그대로 진행
				
				// 흰색
				if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == 0) {
					// foreach에서 바로 삭제를 하면 위험하기 때문에 tmp 사용
					List<Integer> tmp = new ArrayList<>();
					boolean flag = false;
					
					for(int a : stackHorse[x][y]) {
						if(a == i) flag = true; // i가 나오면 true
						if(flag) {
							stackHorse[nx][ny].add(a); // i부터 위에있는 말을 nx, ny에 넣음
							tmp.add(a); 
						}
					}
					
					// 삭제
					for(int a : tmp) {
						//int ax = horse.get(a-1)[0];
						//int ay = horse.get(a-1)[1];
						stackHorse[x][y].remove((Integer) a);
						// 삭제 후 horse의 좌표 변경
						horse.get(a-1)[0] = nx;
						horse.get(a-1)[1] = ny;
					}
				}
				
				// 빨강인경우
				else if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == 1) {
					List<Integer> tmp = new ArrayList<>();
					
					// 역순으로 접근
					for(int j = stackHorse[x][y].size()-1; j >= 0; j--) {
						int a = stackHorse[x][y].get(j);
						stackHorse[nx][ny].add(a);
						tmp.add(a);
						
						// i까지 다 빼면 멈춤
						if(a==i) break;
					}
					
					// 제거
					for(int a : tmp) {
						//int ax = horse.get(a-1)[0];
						//int ay = horse.get(a-1)[1];
						stackHorse[x][y].remove((Integer) a);
						// horse 좌표에 반영
						horse.get(a-1)[0] = nx;
						horse.get(a-1)[1] = ny;
					}
				}
				
				// 계속 순회하며 크기가 4이상이면 ans = cnt 하고 리턴
				for(int k = 1 ; k <= K; k++) {
					int kx = horse.get(k-1)[0];
					int ky = horse.get(k-1)[1];
					if(stackHorse[kx][ky].size() >= 4) {
						ans = cnt;
						return;
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// (1) 체스판 크기, 말의 개수 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 사용할 보드와 위치에 따른 말을 저장하는 리스트 선언
		board = new int[N+1][N+1];
		stackHorse = new List[N+1][N+1];
		
		// (2) 체스판 채우기
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				stackHorse[i][j] = new ArrayList<>();
			}
		}
		
		// (3) 말 채우기
		horse = new ArrayList<>();
		for(int i = 1 ; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			horse.add(new int[] {x, y, d}); // pos, 방향 저장
			stackHorse[x][y].add(i); // 해당 좌표에 i번 말 저장
		}
		
		ans = -1;
		solve();
		System.out.println(ans);
		br.close();
	}
}
