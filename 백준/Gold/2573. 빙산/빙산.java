import java.io.*;
import java.util.*;
public class Main {
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(true) {
			//check
			boolean[][] v = new boolean[N][M];
			int cnt = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					if(!v[i][j] && board[i][j] != 0) {
						ArrayDeque<int[]> q = new ArrayDeque<>();
						q.offer(new int[] {i, j});
						v[i][j] = true;
						cnt++;
						while(!q.isEmpty()) {
							int [] cur = q.poll();
							for(int dir = 0; dir < 4; dir++) {
								int nx = cur[0] + dx[dir];
								int ny = cur[1] + dy[dir];
								
								if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
								if(board[nx][ny] == 0 || v[nx][ny]) continue;
								
								q.offer(new int[] {nx, ny});
								v[nx][ny] = true;
							}
						}
					}
				}
			}
			
			if(cnt == 0) { // 둘로 분리되지 않고 다 녹는경우
				ans = 0;
				break;
			}
			else if (cnt != 1) { // 둘 이상으로 분리
				break;
			}
			
			ans++; 
			
			// melt
			int[][] minus = new int[N][M];
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					if(board[i][j] != 0) {
						for(int dir = 0; dir < 4; dir++) {
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							if(board[nx][ny] == 0) minus[i][j]++;
						}
					}
				}
			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					board[i][j] -= minus[i][j]; board[i][j] = Math.max(0, board[i][j]);
				}
			}	
		}
		System.out.println(ans);
		
		br.close(); 
	}
}