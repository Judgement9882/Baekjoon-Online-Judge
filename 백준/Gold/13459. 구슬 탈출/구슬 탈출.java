import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0}; // 왼 오 위 아
	static char[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int rx=0, ry=0, bx=0, by=9;
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'R') {
					board[i][j] = '.';
					rx = i; 
					ry = j;
				}
				if(board[i][j] == 'B') {
					board[i][j] = '.';
					bx = i; 
					by = j;
				}
			}
		}
		System.out.println(bfs(rx, ry, bx, by));
		br.close();
	}
	
	static int bfs(int prx, int pry, int pbx, int pby) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {prx, pry, pbx, pby, 0}); // 빨강, 파랑, 거리
		while(!q.isEmpty()) {
			int []cur = q.poll();
			// 10번을 넘어서면 break
			if(cur[4] >= 10) break;
			
			int rx = cur[0], ry = cur[1], bx = cur[2], by = cur[3];
			for(int dir = 0; dir < 4 ; dir++) {
				int [] Rtemp = new int[] {1, 1};
				int [] Btemp = new int[] {1, 1};
				
				// 방향에 따라 먼저 이동하는 공이 다름
				if(dir==0) { // 왼
					// 같은 행에 있는 경우 
					if(bx == rx) {
						if(ry < by) {
							Rtemp = moveRed(dir, rx, ry);
							Btemp = moveBlue(dir, bx, by);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[1] == Btemp[1]) { // 열이 같을 경우
								Btemp[1]++; // 한칸 오른쪽으로 이동
							}
						}
						else {
							Btemp = moveBlue(dir, bx, by);
							Rtemp = moveRed(dir, rx, ry);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[1] == Btemp[1]) { // 열이 같을 경우
								Rtemp[1]++; // 한칸 오른쪽으로 이동
							}
						}
					}
					
					else {
						Btemp = moveBlue(dir, bx, by);
						Rtemp = moveRed(dir, rx, ry);
					}
				}
				
				else if(dir==1) { // 오
					if(bx == rx) {
						if(ry > by) {
							Rtemp = moveRed(dir, rx, ry);
							Btemp = moveBlue(dir, bx, by);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[1] == Btemp[1]) { // 열이 같을 경우
								Btemp[1]--; // 한칸 왼쪽으로 이동
							}
						}
						else {
							Btemp = moveBlue(dir, bx, by);
							Rtemp = moveRed(dir, rx, ry);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[1] == Btemp[1]) { // 열이 같을 경우
								Rtemp[1]--; // 한칸 왼쪽으로 이동
							}
						}
					}
					else {
						Btemp = moveBlue(dir, bx, by);
						Rtemp = moveRed(dir, rx, ry);
					}
				}
				
				else if(dir==2) { // 위
					if(by==ry) {
						if(rx < bx) {
							Rtemp = moveRed(dir, rx, ry);
							Btemp = moveBlue(dir, bx, by);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[0] == Btemp[0]) { // 행이 같을 경우
								Btemp[0]++; // 한칸 아래쪽으로 이동
							}
						}
						else {
							Btemp = moveBlue(dir, bx, by);
							Rtemp = moveRed(dir, rx, ry);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[0] == Btemp[0]) { // 행이 같을 경우
								Rtemp[0]++; // 한칸 아래쪽으로 이동
							}
						}
					}
					else {
						Btemp = moveBlue(dir, bx, by);
						Rtemp = moveRed(dir, rx, ry);
					}
				}
				
				else if(dir==3) { // 아래
					if(by==ry) {
						if(rx > bx) {
							Rtemp = moveRed(dir, rx, ry);
							Btemp = moveBlue(dir, bx, by);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[0] == Btemp[0]) { // 행이 같을 경우
								Btemp[0]--; // 한칸 위쪽으로 이동
							}
						}
						else {
							Btemp = moveBlue(dir, bx, by);
							Rtemp = moveRed(dir, rx, ry);
							// 파랑 -1 -1 이 왔다면
							if(Btemp[0] == -1 && Btemp[1] == -1) {
								continue;
							}
							if(Rtemp[0] == Btemp[0]) { // 행이 같을 경우
								Rtemp[0]--; // 한칸 위쪽으로 이동
							}
						}
					}
					else {
						Btemp = moveBlue(dir, bx, by);
						Rtemp = moveRed(dir, rx, ry);
					}
				}
				
				// 만약 Rtemp에서 -2, -2가 왔다면 최단거리로 의미없음
				if(Rtemp[0] == -2 && Rtemp[1] == -2) continue;
				// 파랑 -1 -1 이 왔다면
				if(Btemp[0] == -1 && Btemp[1] == -1) {
					continue;
				}
				if(Rtemp[0] == -1 && Rtemp[1] == -1) {
					// 파랑 -1, -1 아닌데 빨강 -1 -1 이면 정답
					return 1;
				}
				q.offer(new int[] {Rtemp[0], Rtemp[1], Btemp[0], Btemp[1], cur[4]+1});
			}
			
		}
		
		return 0;
	}
	
	static int[] moveRed(int dir, int rx, int ry) {
		while(true) {
			int nx = rx + dx[dir];
			int ny = ry + dy[dir];
			
			if(board[nx][ny] == 'O') { // 도착하면 -1, -1 리턴
				return new int[] {-1, -1};
			}
			
			if(board[nx][ny] != '.') { // .이 아니면 #이랑 다른색 구슬
				return new int[] {rx, ry};
			}
			else { // 그대로 진행
				rx = nx; ry = ny;
			}
		}
	}
	static int[] moveBlue(int dir, int bx, int by) {
		while(true) {
			int nx = bx + dx[dir];
			int ny = by + dy[dir];
			
			if(board[nx][ny] == 'O') { // 도착하면 -1, -1 리턴
				return new int[] {-1, -1};
			}
			
			if(board[nx][ny] != '.') { // .이 아니면 #이랑 다른색 구슬
				return new int[] {bx, by};
			}
			else { // 그대로 진행
				bx = nx; by = ny;
			}
		}
	}
	
}