import java.io.*;
import java.util.*;

public class Main{
	
	static int N, M, K, min_sum;
	static int [][] board, cal, rotateCal, temp_board;
	static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1}; // 하우상좌
	static boolean [] isused;
	
	// 4. 최소 행 값 구하기
	static void minSum() {
		for(int i = 0; i < N; i++) {
			int temp_sum = 0;
			for(int j= 0; j < M; j++) {
				temp_sum += temp_board[i][j];
			}
			min_sum = Math.min(temp_sum, min_sum);
		}
	}
	
	// 3. 회전 연산
	static void rotate(int r, int c, int s) {
		for(int m = s; m > 0; m--) {
			int x = r-m;
			int y = c-m; 
			int temp = temp_board[x][y]; // 처음 항을 저장함
			
			int dir = 0; // 최초 방향은 아래쪽
			
			while(true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				// 만약 처음 지점에 도달했다면
				if(nx == r-m && ny == c-m) {
					temp_board[x][y] = temp;
					break;
				}
				
				// 경계값을 넘으면?
				if(nx < r-m || nx > r+m || ny < c-m || ny > c+m || (nx == r && ny == c)) {
					dir = (dir + 1) % 4;
					continue;
				}
				
				// 이전 값 갱신
				temp_board[x][y] = temp_board[nx][ny];
				x = nx; y = ny;
			}
		}
	}
	
	// 2. 순열 구현
	static void perm(int cnt) {
		if(cnt == K) {
			temp_board = new int [N][M];
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					temp_board[i][j] = board[i][j];
				}
			}
			// 순서대로 회전 시작
			for(int i = 0 ; i < cnt; i++) {
				rotate(rotateCal[i][0], rotateCal[i][1], rotateCal[i][2]);
			}
//			System.out.println();
//			for(int x = 0; x < N; x++) {
//				for(int y = 0 ; y < M; y++) {
//					System.out.print(temp_board[x][y] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();			
			minSum();
			return;
		}
		
		for(int i = 0 ; i < K; i++) {
			if(isused[i]) continue;
			isused[i] = true;
			rotateCal[cnt] = cal[i];
			perm(cnt+1);
			isused[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min_sum = Integer.MAX_VALUE;
		
		board = new int[N][M]; // 판
		
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int  j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산 저장
		cal = new int[K][];
		rotateCal = new int[K][];
		isused = new boolean[K];
		
		for(int i = 0; i < K; i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int r, c, s;
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			
			cal[i] = new int[] {r, c, s};
		}
		
		// 1. k! 순열 확인
		perm(0);
		
		System.out.println(min_sum);
		
		br.close();
	}
}