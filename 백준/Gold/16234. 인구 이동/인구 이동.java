import java.io.*;
import java.util.*;

public class Main{

	static int N, L, R, cnt = 0;
	static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] board;
	static boolean[][] vis;
	
	static boolean bfs() {
		boolean resFlag = false;
		vis = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!vis[i][j]) { // 방문하지 않았다면
					vis[i][j] = true; // 방문 처리
					int unionSum = board[i][j]; // sum값 초기화
					int unionNum = 1;
					ArrayDeque<int[]> q = new ArrayDeque<>();
					List<int[]> nation = new ArrayList<int[]>();
					q.offer(new int[] {i, j});
					nation.add(new int[] {i, j});
					while(!q.isEmpty()) {
						int [] xy = q.poll();
						int x = xy[0];
						int y = xy[1];
						for(int dir = 0; dir < 4 ; dir++) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 이탈
							if(vis[nx][ny]) continue; // 다른 연합
							
							// L, R 체크
							int diff = Math.abs(board[nx][ny] - board[x][y]);
//							System.out.println("diff : "+diff+" x:"+x+" y:"+y+"\n");
							if(L <= diff && diff <= R) {
								resFlag = true; // 국경을 만들었으니 true
								vis[nx][ny] = true; // 방문처리
								// 사이에 있을때만 연합이 된다.
								unionSum += board[nx][ny];
								unionNum ++;
								
								q.offer(new int[] {nx, ny});
								nation.add(new int[] {nx, ny});
							}
						}
					}
					
					// 국경선을 다 열었으니 분배해야함
					for(int[] xy : nation) {
						board[xy[0]][xy[1]] = unionSum / unionNum;
					}

				}
			}
		}
		return resFlag;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// bfs or dfs 를 돌려서 반환값이 1 이상이면 cnt 증가
		cnt = 0;
		while(bfs()) {
//			System.out.println();
//			for(int ii = 0 ; ii < N; ii++) {
//				for(int jj = 0 ; jj < N; jj++) {
//					System.out.print(board[ii][jj] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}
