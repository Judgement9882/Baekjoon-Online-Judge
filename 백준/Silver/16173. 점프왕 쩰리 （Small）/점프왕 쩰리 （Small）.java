import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 1, 0 }, dy = { 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		boolean vis[][] = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		vis[0][0] = true;
		boolean ans = false;
		end : while (!q.isEmpty()) {
			int cur[] = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			for (int dir = 0; dir < 2; dir++) {
				int nx = cx + board[cx][cy]*dx[dir];
				int ny = cy + board[cx][cy]*dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || vis[nx][ny]) continue;
				if(nx == N-1 && ny == N-1) {
					ans = true;
					break end;
				}
				
				q.offer(new int[] {nx, ny});
				vis[nx][ny] = true;
			}
		}
		
		if(ans) sb.append("HaruHaru");
		else sb.append("Hing");
		System.out.println(sb);
		br.close();
	}
}