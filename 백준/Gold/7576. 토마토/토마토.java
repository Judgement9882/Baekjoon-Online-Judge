import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0,-1};
	static int[][] board;
	static boolean[][] v;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	static void bfs() {
		while(!q.isEmpty()) {
			
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(v[nx][ny] || board[nx][ny] == -1) continue;
				
				v[nx][ny] = true;
				board[nx][ny] = board[x][y] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		v = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) {
					q.offer(new int[] {i, j});
					v[i][j] = true;
				}
			}
		}
		
		
		bfs();
		
		int ans = 0;
		end : for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
//				System.out.print(board[i][j] + " ");
				if(board[i][j]==0) {
					ans = 0;
					break end;
				}
				ans = Math.max(ans, board[i][j]);
			}
//			System.out.println();
		}
//		System.out.println();
		System.out.println(ans-1);
		br.close();
	}
}