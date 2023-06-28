import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char [][] board;
	static boolean [][] v;
	static Queue<int[]> q = new ArrayDeque<>();	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'I') {
					v[i][j] = true;
					q.offer(new int[] {i, j});
				}
			}
		}
		int ans = bfs();
		System.out.println(ans==0?"TT":ans);
		br.close();
	}
	
	static int bfs() {
		int ret = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur[0];
				int ny = dy[dir] + cur[1];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(v[nx][ny] || board[nx][ny] == 'X') continue;
				
				if(board[nx][ny] == 'P') ret++;
				v[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
		return ret;
	}
}