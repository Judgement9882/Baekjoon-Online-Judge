import java.io.*;
import java.util.*;
public class Main {
	static class shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int[][] site;
	static int R, C, M, r, s, c, d, z, ans;
	static int []dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
	static boolean [] isLive;
	static List<shark> sharks = new ArrayList<>();

	static void catchShark(int j) {
		int i = 1;
		while(true) {
			if(i > R) break; // 범위 이탈
			if(site[i][j] == 0 || !isLive[site[i][j]]) {
				i++;
				continue;
			}
			isLive[site[i][j]] = false;
			ans += sharks.get(site[i][j]).z;
			site[i][j] = 0;
			break;
		}
	}
	
	// index 는 1 베이스
	static void moveShark(int index) {
		// get
		int x = sharks.get(index).r;
		int y = sharks.get(index).c;
		int s = sharks.get(index).s;
		int d = sharks.get(index).d;
		site[x][y] = 0;
		// 특정 방향으로 이동
		while(s-- > 0) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 상하 이동
			if(d==0 || d==1) {
				if(nx < 1 || nx > R) {
					d = (d==0?1:0);
					nx = x + dx[d];
				}
			}
			// 좌우 이동
			else {
				if(ny < 1 || ny > C) {
					d = (d==2?3:2);
					ny = y + dy[d];
				}
			}
			x = nx;
			y = ny;
		}
		
		// set
		sharks.get(index).r = x;
		sharks.get(index).c = y;
		sharks.get(index).d = d;
	}
	
	static void eatShark(int index) {
		shark s = sharks.get(index);
		
		// 만약 기존 자리에 상어가 있다면
		if(site[s.r][s.c] !=0) {
			// 3. 상어 먹기			
			// 기존 것보다 더 크면 기존것을 잡아먹음
			if(sharks.get(site[s.r][s.c]).z < s.z) {
				isLive[site[s.r][s.c]] = false; //잡아먹힘
				site[s.r][s.c] = index; // 새로갱신
			}
			else {
				// 기존것이 더 커서 새로 들어온것이 잡아먹힘
				isLive[index] = false;
			}
		}
		else { // 기존에 없다면 그냥 넣음
			site[s.r][s.c] = index;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		site = new int[R+1][C+1];
		isLive = new boolean[M+1]; // 1베이스
		Arrays.fill(isLive, true); // 전부 있다고 초기화
		sharks.add(new shark(1, 1, 1, 1, 1)); // 1베이스를 위한 임시 상어
		for(int i = 1; i <= M; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			
			// 속력 처리
			if(d < 2) s = s % (2*(R-1));
			else s = s % (2*(C-1));
			
			sharks.add(new shark(r, c, s, d, z));
			site[r][c] = i; // 인덱스 저장 1부터 시작 주의!!
		}
		

		for(int m = 1; m <= C; m++) {
			// 1. 상어 잡기
			catchShark(m);
			
			// 2. 상어 이동 
			for(int i = 1; i <= M; i++) {
				if(isLive[i]) { // 살아있는 상어만 이동
					moveShark(i); 
				}
			}
			
			// 3. 큰 상어가 나머지 먹음
			for(int i = 1; i <= M; i++) {
				if(isLive[i]) { // 살아있는 상어만 이동
					eatShark(i); 
				}
			}
		}
		
		System.out.println(ans);
	}
}