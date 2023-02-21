import java.io.*;
import java.util.*;

public class Main{
	
	static int R, C, ans;
	static int[] dx = {-1, 0, 1};
	
	static char[][] board;
	static boolean[][] vis;
	static boolean success;
	
	static void dfs(int x, int y) {
		if(success) return;
		vis[x][y] = true;
//		System.out.println(x+" "+y);
		
		if(y == C-1) {
			ans++;
			success = true;
			return;
		}
			
		for(int dir = 0; dir < 3; dir++) {
			int nx = x + dx[dir];
			int ny = y+1;
			// 경계체크 및 파이프 체크
			if(nx < 0 || nx >= R || vis[nx][ny]) continue;
			// 건물이면 pass
			if(board[nx][ny] == 'x') continue;
			
			dfs(nx, ny);
			
			// 성공하면 바로 리턴
			if(success) return;
		}
		// 성공아니라면 그간의 자취를 지워야함
//		vis[x][y] = false;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		board = new char[R][C];
		vis = new boolean[R][C];
		
		for(int i = 0 ; i < R; i++) {
			String temp = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0 ; i < R; i++) {
			success = false;
			dfs(i, 0);
//			System.out.println();
		}
//		System.out.println();
//		for(int i = 0 ; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print((vis[i][j]?1:0)+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);
		
	}
}
