import java.io.*;
import java.util.*;

public class Main{
	
	static int dx[] = { 1, 0, -1, 0 }, dy[] = { 0, 1, 0, -1 };
	static int [][] board, test_board;
	static int N, M, ans;
	static ArrayList<int[]> cctv;
	static int[] d;
	
	static void straight(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		while (!(nx < 0 || ny < 0 || nx >= N || ny >= M)) {
			int temp = test_board[nx][ny];

			// 벽을 만나면 종료
			if (temp == 6) break;

			// 이미 방문했거나 cctv면 패스하고 0일경우에만 입력
			if (temp == 0) {
				test_board[nx][ny] = 8; // #대신 8로 사용
			}
			nx += dx[dir];
			ny += dy[dir];
		}
	}
	
	static void init_board() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				test_board[i][j] = board[i][j];
			}
		}
	}
	
	static void checkSafeArea() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (test_board[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
	
	static void perm(int cnt) {
		if(ans==0) return;
		
		if(cnt == cctv.size()) {
			init_board();
			for(int m = 0; m < cctv.size(); m++) {
				if (cctv.get(m)[2] == 1) {
					straight(cctv.get(m)[0], cctv.get(m)[1], d[m]);
				}
				else if (cctv.get(m)[2] == 2) {
					straight(cctv.get(m)[0], cctv.get(m)[1], d[m]);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+2)%4);
				}
				else if (cctv.get(m)[2] == 3) {
					straight(cctv.get(m)[0], cctv.get(m)[1], d[m]);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+1)%4);
				}
				else if (cctv.get(m)[2] == 4) {
					straight(cctv.get(m)[0], cctv.get(m)[1], d[m]);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+1)%4);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+2)%4);
				}	
				else if (cctv.get(m)[2] == 5) {
					straight(cctv.get(m)[0], cctv.get(m)[1], d[m]);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+1)%4);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+2)%4);
					straight(cctv.get(m)[0], cctv.get(m)[1], (d[m]+3)%4);
				}
			}
			checkSafeArea();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			d[cnt] = i;
			perm(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		test_board = new int[N][M];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if ((board[i][j] != 0) && (board[i][j] != 6)) {
					cctv.add(new int[] {i, j, board[i][j]});
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		d = new int[cctv.size()];
		perm(0);
		System.out.println(ans==Integer.MAX_VALUE?"-1":ans);
		br.close();
	}
}
