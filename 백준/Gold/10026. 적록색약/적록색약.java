import java.io.*;
import java.util.*;

public class Main{

	static int N, ans, Rans;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] board, Rboard;
	static boolean [][] v, Rv;

	static boolean checkRangeOut(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	}
	
	static void bfs(int x, int y, boolean[][] v, char[][] board) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ; dir < 4 ; dir++) {
				int nx = dx[dir] + cur[0];
				int ny = dy[dir] + cur[1];
				
				// 범위 밖, 방문, 이전과 같지 않을 경우 continue
				if(checkRangeOut(nx, ny)) continue;
				if(v[nx][ny] || board[nx][ny] != board[cur[0]][cur[1]]) continue;
				
				v[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	static void dfs(int x, int y, boolean[][] v, char[][] board) {
		v[x][y] = true;
		
		for(int dir = 0 ; dir < 4 ; dir++) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;
			
			// 범위 밖, 방문, 이전과 같지 않을 경우 continue
			if(checkRangeOut(nx, ny)) continue;
			if(v[nx][ny] || board[nx][ny] != board[x][y]) continue;
			dfs(nx, ny, v, board);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		Rboard = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j);
				if (board[i][j] == 'G')
					Rboard[i][j] = 'R';
				else
					Rboard[i][j] = board[i][j];
			}
		}

		v = new boolean[N][N];
		Rv = new boolean[N][N];
		ans = 0;
		Rans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
					ans++;
//					bfs(i, j, v, board);
					dfs(i, j, v, board);
				}
				
				if(!Rv[i][j]) {
					Rans++;
//					bfs(i, j, Rv, Rboard);
					dfs(i, j, Rv, Rboard);
				}
			}
		}
		
		System.out.println(ans + " " + Rans);
		br.close();
	}
}
