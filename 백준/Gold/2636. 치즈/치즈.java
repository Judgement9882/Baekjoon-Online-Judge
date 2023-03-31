import java.io.*;
import java.util.*;
public class Main {
	static int M, N, time, cnt;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int [][] board, copy_board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[M][N];
		copy_board = new int[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		
		br.close();
	}
	
	static void solve() {
		time = 0;
		
		while(true) {
			// 0. copy board 생성 - 복사, time++
			copy(); time++;
			
			// 1. copy board에 공기 영역을 -1로 바꾸기
			changeAir();
			
			// 2. copy board 에서 공기와 겹치는 부분을 board에서 0으로 바꾸기
			// 바꾸면서 cnt 기록
			cnt = 0; // 초기화
			melt();
			
			
			// 3. 만약 모두 0이라면 time, cnt 출력하고 종료
			if(checkZero()) {
				System.out.println(time);
				System.out.println(cnt);
				break;
			}
		}
	}
	
	static void copy() {
		for(int i = 0; i < M; i++) 
			for(int j = 0; j < N; j++) 
				copy_board[i][j] = board[i][j];
	}
	
	static void changeAir() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		copy_board[0][0] = -1;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for(int dir = 0 ; dir < 4; dir++) {
				int nx =cur[0] +dx[dir];
				int ny =cur[1] +dy[dir];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(copy_board[nx][ny] == 0) {
					copy_board[nx][ny] = -1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	static void melt() {
		for(int i = 1; i < M-1; i++) {
			ret : for(int j = 1; j < N-1; j++) {
				if(board[i][j] == 1) { // 1이면 치즈
					for(int dir = 0 ; dir < 4; dir++) {
						int nx = i +dx[dir];
						int ny = j +dy[dir];
						
						if(copy_board[nx][ny] == -1) { // 하나라도 공기와 맞닿는다면
							board[i][j] = 0;
							cnt++;
							continue ret;
						}
					}	
				}
			}
		}
	}
	
	static boolean checkZero() {
		for(int i = 0; i < M; i++) 
			for(int j = 0; j < N; j++) 
				if(board[i][j] != 0) return false;
		return true;
	}
}