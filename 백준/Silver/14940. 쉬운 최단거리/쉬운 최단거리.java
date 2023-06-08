import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int []dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int [][] board = new int[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i = 0 ;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					board[i][j] = 2;
					q.offer(new int[] {i, j});
				}
			}
		}
		

		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ; dir < 4; dir++) {
				int nx = cur[0]+dx[dir];
				int ny = cur[1]+dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(board[nx][ny] == 1) {
					board[nx][ny] = board[cur[0]][cur[1]] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}

		// 다시 탐색하는걸 막기위해 0이면 그대로 0, 1이면 -1, 2이상이면 -2를 해서 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] >= 2) sb.append(board[i][j]-2).append(" ");
				else if (board[i][j] == 1) sb.append(-1).append(" ");
				else sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}