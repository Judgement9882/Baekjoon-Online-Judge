import java.io.*;
import java.util.*;
public class Main {
	// 아래로 가는 방향만 빼고
	static int[] dx = {1, 0, -1, -1, -1, 0, 1}, dy = {-1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 시작 F
		int startX = 0, startY = 0; 
		
		// 입력
		char [][] board = new char[N][N];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'F') {
					startX = i;
					startY = j;
				}
			}
		}
		 
		// BFS로 가능한 지점 구하기 
		int ans = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX, startY});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ; dir < 7; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(board[nx][ny] != '.') continue;
				
				// 갔다고 체크
				board[nx][ny] = 'V';
				ans++;
				q.offer(new int[] {nx, ny});
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}