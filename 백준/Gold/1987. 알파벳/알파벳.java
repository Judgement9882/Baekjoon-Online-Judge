import java.io.*;
import java.util.*;

public class Main{
	static int R, C, ans;
	static int[][] board;
	static boolean [] alphabet;
	static int[] dx = {0, 1, 0, -1}, dy= {1, 0, -1, 0}; // 우하좌상
	
	static void dfs(int x, int y, int sum) {
		// 방문처리
		alphabet[board[x][y]] = true;
		for(int d = 0 ; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(alphabet[board[nx][ny]]) continue;
			
			alphabet[board[nx][ny]] = true;
			dfs(nx, ny, sum+1);
			alphabet[board[nx][ny]] = false;
		}
		ans = Math.max(ans, sum);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		for(int i = 0 ; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j) - 'A';
			}
		}
		
		alphabet = new boolean[26];
		ans = 0;
		dfs(0, 0, 1);
		
		System.out.println(ans);
		br.close();
	}
}
