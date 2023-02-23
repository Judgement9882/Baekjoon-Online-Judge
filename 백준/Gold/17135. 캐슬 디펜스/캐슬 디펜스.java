import java.io.*;
import java.util.*;
// 1. 디버깅 : 같은 적이 여러 궁수에게 공격당할 수 있다.
public class Main{
	static int N, M, D, sum, ans;
	static int [] dx = {0, -1, 0}, dy = {-1, 0, 1};
	
	static boolean[][] board, copy_board, vis;
	static boolean[] isused;

	static ArrayDeque<int[]> enemy = new ArrayDeque<>();
	
	static void copy() {
		copy_board = new boolean[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				copy_board[i][j] = board[i][j];
	}
	
	static void killEnemy() {
		while(!enemy.isEmpty()) {
			int [] temp = enemy.poll();
			if(copy_board[temp[0]][temp[1]]) {
				copy_board[temp[0]][temp[1]] = false;
				sum++;
			}
		}
	}
	
	static void bfs(int x, int y) {
		// 시작부터 1인경우
		if(copy_board[x][y]) {
//			copy_board[x][y] = false;
//			sum++;
			enemy.offer(new int[] {x, y});
			return;
		}
		
		vis = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		vis[x][y] = true;
		
		// D만큼 BFS 진행
		int depth = 1;
		while(depth++ != D) {
			int q_size = q.size();
			while(q_size -- > 0) {
				int [] cur = q.poll();
				for(int dir = 0; dir < 3; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					// 범위체크
					if(nx < 0 || ny < 0 || ny >= M) continue;
					if(vis[nx][ny]) continue;
					vis[nx][ny] = true;
					// 만약 적이 있다면 제거하고 카운트
					if(copy_board[nx][ny]) {
//						copy_board[nx][ny] = false;
//						sum++;
						enemy.offer(new int[] {nx, ny});
						return;
					}
					
					// 적이없다면 bfs 진행
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 3) {
			// 궁수의 위치(조합)을 다 정했음
			copy();
			sum = 0; // 합을 저장하는 변수
			
			// N만큼 적이 다가옴
			for(int i = N-1; i >= 0; i--) { 
				for(int j = 0; j < M; j++) {
					if(isused[j]) {
						bfs(i, j);
						
					}
				}
				killEnemy();
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int index = start ; index < M; index++) {
			isused[index] = true;
			comb(cnt+1, index+1);
			isused[index] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = st.nextToken().equals("1")?true:false;
			}
		}
		ans = 0;
		isused = new boolean[M];
		// 궁수의 위치 정하기
		comb(0, 0);
		System.out.println(ans);
		
	}
}

