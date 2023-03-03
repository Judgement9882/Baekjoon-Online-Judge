import java.io.*;
import java.util.*;

public class Main {
	static class shark{
		int x;
		int y;
		int size;
		int stack;
		public shark(int x, int y, int size, int stack) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.stack = stack;
		}
	}
	
	static int N, ans;
	// 우선순위는 상, 좌, 우, 하
	static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
	static int[][] board;
	static shark s;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{
				int r = Integer.compare(o1[0], o2[0]);
				if(r==0) r = Integer.compare(o1[1], o2[1]);
				return r;
			});
	
	static boolean bfs() {
		boolean [][] v = new boolean[N][N];
		q.clear();
		pq.clear();

		// x, y 좌표 넣음
		board[s.x][s.y] = 0;
		v[s.x][s.y] = true; 
		q.offer(new int[] {s.x, s.y, 0});
		
		end : while(!q.isEmpty()) {		
			int [] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			
			for(int dir =0; dir < 4;dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				// 범위 체크
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(v[nx][ny]) continue; // 방문 체크
				
				// 1) 물고기 사이즈가 더 크면 못지나감
				if(board[nx][ny] > s.size) continue;
				
				// 2) 물고기 사이즈가 작으면 먹을 수 있음
				// pq에 넣고 후에 확인
				if(board[nx][ny]!=0 && board[nx][ny] < s.size) {
					// 없으면 그냥 넣음
					if(pq.isEmpty()) pq.offer(new int[] {nx, ny, dist});
					else {
						int [] pos = pq.peek();
						if(pos[2] != dist) break end;
						// 같으면 그냥 넣고 다르면 break
						else pq.offer(new int[] {nx, ny, dist});
					}
				}
				
				// 3) 물고기 사이즈가 같거나 빈 칸이면 이동  
				else if(board[nx][ny] == 0 || board[nx][ny] == s.size) {
					v[nx][ny] = true;
					q.offer(new int[] {nx, ny, dist+1});
				}
			}
		}
		
		
		
		if(pq.isEmpty()) return false; // 물고기 없음
		int [] pos = pq.poll();
		board[pos[0]][pos[1]] = 0; // 물고기 사망
		// 2. 물고기가 결정되면 해당자리로 옮기고 stack, size, ans 관리
		s.x = pos[0];
		s.y = pos[1];
		s.stack++;
		if(s.stack == s.size) {
			s.stack = 0;
			s.size++;
		}
		ans += pos[2]+1;
		return true;
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 9) s = new shark(i, j, 2, 0);
			}
		}
		ans = 0;
		while(true) {
			// 1. 현재 상어 위치에서 BFS를 돌려 가장 가까운 물고기 찾기
			boolean flag = bfs();
			
			// 3. 물고기 없을 경우 엄마 상어에게 도움 요청
			if(!flag) break;
//			
//			System.out.println(ans);
//			for(int i = 0 ; i < N; i++) {
//				for(int j = 0 ; j < N; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		System.out.println(ans);
		br.close();
	}
}