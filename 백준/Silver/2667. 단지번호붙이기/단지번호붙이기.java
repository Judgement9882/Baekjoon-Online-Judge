import java.util.*;
import java.io.*;

public class Main{

	static int N, danji, num;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] v;
	static ArrayList<Integer> houseNum = new ArrayList<>(); // 집의 수
	
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true; // 방문처리
		q.offer(new int[] { i, j }); // 큐에 넣음
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			for (int d = 0; d < 4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(v[nx][ny] || board[nx][ny] == 0) continue;
				
				v[nx][ny] = true; // 방문
				num++; // 세대 수 증가 
				q.offer(new int[] {nx, ny}); // 큐에 넣기
			}
		}
		
		
	}
	
	static void dfs(int x, int y) {
		v[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(v[nx][ny] || board[nx][ny] == 0) continue;
			
			v[nx][ny] = true; // 방문
			num++;
			dfs(nx, ny);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		danji = 0;
		
		// 지도와 방문여부 초기화
		board = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && !v[i][j]) {
					danji++; // 단지 수 증가
					num = 1;
//					bfs(i, j);
					dfs(i, j);
					houseNum.add(num); // 세대수 넣기
					
				}
			}
		}
		
		
		
		System.out.println(danji);
		Collections.sort(houseNum);
		for(int i= 0; i < houseNum.size(); i++) {
			System.out.println(houseNum.get(i));
		}
		
		br.close();
	}
}
