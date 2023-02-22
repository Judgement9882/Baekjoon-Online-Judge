import java.io.*;
import java.util.*;

public class Main{
	
	static int w, h, sum;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static boolean[][] board, vis;

	static boolean checkOutOfRange(int x, int y) {
		return x < 0 || x >= h || y < 0 || y >= w; 
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		vis[x][y] = true;
		q.offer(new int[] {x, y});
			
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			for(int dir = 0 ; dir < 8; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(checkOutOfRange(nx, ny)) continue;
				if(vis[nx][ny] || !board[nx][ny]) continue;
				
				vis[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}		
	}
	static void dfs(int x, int y) {
		vis[x][y] = true;
		for(int dir = 0 ; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(checkOutOfRange(nx, ny)) continue;
			if(vis[nx][ny] || !board[nx][ny]) continue;
			
			dfs(nx, ny);
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			board = new boolean[h][w];
			for(int i = 0;i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
				}
			}
			
			vis = new boolean[h][w];
			sum = 0;
			for(int i = 0;i < h; i++) {
				for(int j = 0 ; j < w; j++) {
					// 방문했거나 false이면 continue
					if(vis[i][j] || !board[i][j]) continue;
//					bfs(i, j);
					dfs(i, j);
					sum++;
				}
			}
			
			System.out.println(sum);
		}
		
		
	}
}
