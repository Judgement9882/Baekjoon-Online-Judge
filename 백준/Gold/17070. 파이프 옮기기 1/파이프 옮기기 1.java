import java.io.*;
import java.util.*;
public class Main {
	static int [] dx = {0, 1, 1}, dy = {1, 1, 0};
	static int[][] board;
	static int N, cnt;
	static void dfs(int x, int y, int state) {
		
		if(x == N-1 && y == N-1) {
			cnt++;
			return;
		}
		
		if(state == 0) { // 동쪽
			if(y+1<N &&board[x][y+1] == 0) {
				dfs(x, y+1, 0);
			}
			if(x+1 < N && y+1 < N && board[x][y+1] == 0 && board[x+1][y+1] == 0 && board[x+1][y] == 0) {
				dfs(x+1, y+1, 1);
			}
		}
		else if (state == 1) { // 남동쪽
			if(y+1 < N &&board[x][y+1] == 0) {
				dfs(x, y+1, 0);
			}
			if(x+1 < N && y+1 < N && board[x][y+1] == 0 && board[x+1][y+1] == 0 && board[x+1][y] == 0) {
				dfs(x+1, y+1, 1);
			}
			if(x+1 < N && board[x+1][y] == 0) {
				dfs(x+1, y, 2);
			}
		}
		else { // 남쪽
			if(x+1 < N && y+1 < N && board[x][y+1] == 0 && board[x+1][y+1] == 0 && board[x+1][y] == 0) {
				dfs(x+1, y+1, 1);
			}
			if(x+1 < N && board[x+1][y] == 0) {
				dfs(x+1, y, 2);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		dfs(0, 1, 0);
		System.out.println(cnt);
		br.close();
	}
}