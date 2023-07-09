import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
		int max_x = 0, max_y = 0;
		boolean [][] board = new boolean[101][101];
		for(int r = 0 ; r < 4; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 최대최소 갱신
			min_x = Math.min(min_x, x1);
			min_y = Math.min(min_y, y1);
			max_x = Math.max(max_x, x2);
			max_y = Math.max(max_y, y2);
			
			// 색칠
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					board[i][j] = true;
				}
			}
		}
		
		int ans = 0;
		for(int i = min_x; i < max_x; i++) {
			for(int j = min_y; j < max_y; j++) {
				if(board[i][j]) ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}