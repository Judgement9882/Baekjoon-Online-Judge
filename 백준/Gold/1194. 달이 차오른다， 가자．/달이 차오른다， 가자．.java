import java.io.*;
import java.util.*;
public class Main {
	static int N, M, min;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char [][] board;
	static boolean [][][] v;
	static Queue<int[]> q = new ArrayDeque<>();	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		v = new boolean[N][M][1<<6];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == '0') {
					board[i][j] = '.';
					// x, y, key, dist
					v[i][j][0] = true;
					q.offer(new int[] {i, j, 0, 0});
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		bfs();
//		System.out.println(bfs());
		System.out.println(min==Integer.MAX_VALUE?"-1":min);
		br.close();
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur[0];
				int ny = dy[dir] + cur[1];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				// 똑같은 키를 가지고 방문하거나 벽을 만나면
				if(v[nx][ny][cur[2]] || board[nx][ny] == '#') continue;
				
				if(min < cur[3]+1) continue;
				// 1을 만나면 return
				if(board[nx][ny] == '1') {
					min= Math.min(min, cur[3]+1);
//					return cur[3]+1; 
				}
				
				// 빈 칸이 아니라면
				if(board[nx][ny]!='.') {
					// 문 (대문자)
					if(65 <= board[nx][ny] && board[nx][ny] <= 90) {
						int key = 1 << (board[nx][ny] - 'A');
						// 키를 가지고 있다면 이동 가능
						if((cur[2] & key) != 0) { 
//							System.out.println("문 부숨" + cur[2]);
//							System.out.println("문 부숨" + key);
							v[nx][ny][cur[2]] = true;
							q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
						}
					}
//					// 열쇠
					else if(97 <= board[nx][ny] && board[nx][ny] <= 122) {
//						int key = 1 << (board[nx][ny] - 'a');
//						// 키가 없다면 키를 획득
//						if((cur[2] & key) == 0) {
//							System.out.println("키획득 : "+key);
//							cur[2] |= key;
//							v[nx][ny][cur[2]] = true;
//							q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
//						}
						v[nx][ny][cur[2]] = true;
						q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
					}
				}else { // 빈칸이라면
					v[nx][ny][cur[2]] = true;
					q.offer(new int[] {nx, ny, cur[2], cur[3]+1});
				}
			}
			
			// 열쇠 칸일 경우
			if(97 <= board[cur[0]][cur[1]] && board[cur[0]][cur[1]] <= 122) {
				int key = 1 << (board[cur[0]][cur[1]] - 'a');
				// 키가 없다면 키를 획득
				if((cur[2] & key) == 0) {
//					System.out.println("키획득 : "+key);
					cur[2] |= key;
					v[cur[0]][cur[1]][cur[2]] = true;
					q.offer(new int[] {cur[0], cur[1], cur[2], cur[3]});
				}
			}
		}
		
		return -1;
	}
}