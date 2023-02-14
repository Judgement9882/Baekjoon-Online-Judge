import java.io.*;
import java.util.*;

public class Main{
	static int N, M, R;
	static int [][] board, copy_board;
	static boolean [][] vis;
	static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static void func() {
		while(R-- > 0) {
			// 초기화
			copy_board = new int[N][M];
			vis = new boolean[N][M];
			for(int i = 0; i < Math.min(N, M) / 2; i++) {
				int dir = 0;
				int x = i;
				int y = i;
				while (true) {
					int nx = dx[dir] + x;
					int ny = dy[dir] + y;
					
					// 경계 밖
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || vis[nx][ny]) {
						dir = (dir + 1) % 4;
						continue;
					}
					
					copy_board[nx][ny] = board[x][y];
					vis[nx][ny] = true;
					x = nx;
					y = ny;
					
					// 처음으로 돌아온 경우
					if(nx == i && ny == i) {
						break;
					}
				}
			}
			
			// 붙여넣기
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < M; j++) {
					board[i][j] = copy_board[i][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int [N][M];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
