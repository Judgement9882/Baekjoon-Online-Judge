import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static int board[][];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static boolean [][] v;
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				// 만약 nx, ny가 도착점이다? 출력하고 return
				if(nx == N-1 & ny == M-1) {
					System.out.println(board[cur[0]][cur[1]]+1);
					return;
				}
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(v[nx][ny] || board[nx][ny] == 0) continue;
				
				v[nx][ny] = true;
				board[nx][ny] = board[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx, ny});
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0 ;j < M; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}
		
		v = new boolean[N][M];
		bfs(0, 0);
		
		
		br.close();
	}
}
