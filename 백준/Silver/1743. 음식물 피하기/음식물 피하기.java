import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static boolean[][] v;
	static int [][] board;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		v = new boolean[N][M];
		board = new int[N][M];
		
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			board[r][c]=1;
		}
		

		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0 ;j < M; j++) {
				if(!v[i][j] && board[i][j] != 0) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);
		br.close();
	}	
	
	static int bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		v[x][y] = true;
		int ret = 1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();

			for(int dir = 0 ; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(board[nx][ny] == 0 || v[nx][ny]) continue;
				q.offer(new int[] {nx, ny});
				v[nx][ny] = true;
				ret++;
			}
		}
		return ret;
	}
}