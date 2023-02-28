import java.io.*;
import java.util.*;

public class Main{
	static int N, ans;
	static int[][] board, temp_board;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static List<int[]> island;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	
	
	static void copy_board(){
		temp_board = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				temp_board[i][j] = board[i][j];
			}
		}
	}
	
	static void solve() {
		for(int[] m : island) {
			copy_board();
			int x = m[0], y = m[1];
			int color = board[x][y]; // 해당 영역의 색깔

			temp_board[x][y] = 1;
			q.offer(new int[] {x, y});
			while(!q.isEmpty()) {
//				if(x == 4 && y == 3) {
//					System.out.println();
//					for(int i = 0 ; i < N; i++) {
//						for(int j = 0 ; j < N; j++) {
//							System.out.print(temp_board[i][j] + "  ");
//						}
//						System.out.println();
//					}
//					System.out.println("ans : " + ans);
//					System.out.println();
//				}
				
				int cur[] = q.poll();
				for(int dir = 0 ;dir < 4;dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					// 같은 영역이면 패스
					if(temp_board[nx][ny] == color) continue;
					// 이미 다리를 두려고 계획중이라면
					if(temp_board[nx][ny] > 0) continue;
					
					// 다른 영역의 대륙에 도달했다면
					if(temp_board[nx][ny] < 0) {
						ans = Math.min(ans, temp_board[cur[0]][cur[1]]-1);
						q.clear();
						break;
					}
					
					temp_board[nx][ny] = temp_board[cur[0]][cur[1]]+1;
//					// 최소 다리 길이를 넘어선다면
//					if(ans < temp_board[nx][ny]+1) {
//						q.clear();
//						break;
//					}
					q.offer(new int[] {nx, ny});
				}
			}
			
		}
	}
	
	static void bfs(int x, int y, int color) {
		board[x][y] = color;
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ;dir < 4;dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(board[nx][ny] != -1) continue;
				
				board[nx][ny] = color;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		board= new int[N][N];
		island = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0;j < N; j++) {
				// 육지는 -1
				board[i][j] = -Integer.parseInt(st.nextToken());
				if(board[i][j]==-1) island.add(new int[] {i, j});
			}
		}
		
		// 같은 영역 확인
		int area = -2;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(board[i][j] == -1) {
					bfs(i, j, area--);
				}
			}
		}
		
		
		ans = Integer.MAX_VALUE;
		solve();
		System.out.println(ans);
		br.close();
	}
}
