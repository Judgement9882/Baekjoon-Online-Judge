

import java.io.*;
import java.util.*;

public class Main {
	
	public static int N, M, r, c, d;
	public static int[] dx= {-1, 0, 1, 0};
	public static int[] dy= {0, 1, 0, -1};
	static int[][] board;
	static int[][] vis;
	static int ans = 1;
	
	static void dfs(int x, int y, int d) {
		for(int dir = 0; dir < 4 ; dir++) {
			// 왼쪽
			int left = (d+3 - dir) % 4;
			
			int nx = x + dx[left];
			int ny = y + dy[left];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			// 벽이라면
			if(board[nx][ny]==1) continue;
			
			// 청소가 안되어있고 벽이 아니면 청소함. 
			if(vis[nx][ny]==0 && board[nx][ny] != 1) {
				vis[nx][ny] = 1;
				ans++;
				dfs(nx, ny, left);
				
			}
		}
		
		// 후진
		int back = d < 4 - 2 ? d+2 : d-2;
		int bx = x + dx[back];
		int by = y + dy[back];
		if(bx >= 0 && bx < N && by >= 0 && by < M ) {
			if(board[bx][by] == 0) {
				// 후진
				dfs(bx, by, d);
			}
			
			// 후진 못함
			else {
				System.out.println(ans);
				System.exit(0);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		vis = new int[N][M];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		vis[r][c] = 1;
		dfs(r, c, d);
		
		
	}
}
