import java.io.*;
import java.util.*;
public class Main {
	
	static int N, ans;
	static int [][] board, info;
	static final int INF = Integer.MAX_VALUE/2;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static void solve() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		board[0][0] = 0;
		q.push(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				// 새로운 좌표의 값이 더 크면 작은값으로 갱신
				if(board[nx][ny] > board[cur[0]][cur[1]]) {
					// 검은방인 경우
					if(info[nx][ny] == 0) {
						board[nx][ny] = board[cur[0]][cur[1]]+1;
					}
					else { // 흰 방인경우 
						board[nx][ny] = board[cur[0]][cur[1]];
					}
					
					q.push(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		info = new int[N][N];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < temp.length(); j++) {
				board[i][j] = INF;
				info[i][j] = temp.charAt(j) - '0';
			}
		}
		solve();
		System.out.println(board[N-1][N-1] == INF ? 0 : board[N-1][N-1]);
		br.close();
	}
}