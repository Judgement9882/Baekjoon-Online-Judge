import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		boolean[][] vis = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		int size = 0;
		ArrayList<Integer> num = new ArrayList<>();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (board[i][j] == 1 && !vis[i][j]) {
					int danji = 1;
					q.offer(new int[] { i, j });
					vis[i][j] = true;
					size++;
					
					while (!q.isEmpty()) {
						int[] xy = q.poll();
						int x = xy[0];
						int y = xy[1];
						for (int d = 0; d < 4; d++) {
							int nx = dx[d] + x;
							int ny = dy[d] + y;

							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue;
							if(vis[nx][ny] || board[nx][ny] == 0) continue;
							
							vis[nx][ny] = true;
							danji++;
							q.offer(new int[] {nx, ny});
						}
					}
					
					num.add(danji);
				}
			}
		}

		System.out.println(size);
		Collections.sort(num);
		for(int i= 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
		
		br.close();
	}
}
