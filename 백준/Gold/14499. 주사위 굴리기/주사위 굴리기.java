import java.io.*;
import java.util.*;
public class Main {
	static int[][] board;
	static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
	static int[] dice;
	static int N, M, x, y, K;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6]; // 주사위는 6면
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < K; i++) {
			// 명령 시작. %4로 남쪽을 0으로.
			int order = Integer.parseInt(st.nextToken())%4;
			
			// 1. 주사위 굴리기 (해당 명령 무시 포함)
			boolean ignore = move(order); // 무시하면 true 반환 
			if(!ignore) {
				// 2. 면에 대한 처리
				changeNumber();
				
				// 3. 출력 (해당 명령 무시 포함)
				printNum();
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	static boolean move(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) return true; // 명령 무시
		x = nx; y = ny; // 위치 갱신
		// 1) 방향에 따른 주사위 순서 변환
		orderChange(dir);
		return false;
	}
	
	static void orderChange(int dir) {
		// 남쪽
		// 012345 -> 302541
		if(dir==0) {
			int temp = dice[0]; 
			dice[0]  = dice[3]; 
			dice[3]  = dice[5]; 
			dice[5]  = dice[1]; 
			dice[1]  = temp;
		}
		
		// 동쪽
		// 410352
		else if(dir==1) {
			int temp = dice[0]; 
			dice[0]  = dice[4]; 
			dice[4]  = dice[5]; 
			dice[5]  = dice[2]; 
			dice[2]  = temp;
		}
		
		// 서쪽
		// 215304
		else if(dir==2) {
			int temp = dice[0]; 
			dice[0]  = dice[2]; 
			dice[2]  = dice[5]; 
			dice[5]  = dice[4]; 
			dice[4]  = temp;
		}
		
		// 북쪽
		// 152043
		else if(dir==3) {
			int temp = dice[5]; 
			dice[5]  = dice[3]; 
			dice[3]  = dice[0]; 
			dice[0]  = dice[1]; 
			dice[1]  = temp;
		}
	}
	
	static void changeNumber() {
		// 이동한 칸에 쓰여 있는 수가 0이면
		if( board[x][y] == 0) {
			board[x][y] = dice[5]; // 복사
		}
		
		else { // 0이 아니면
			dice[5] = board[x][y];
			board[x][y] = 0;
		}
	}
	
	static void printNum() {
		sb.append(dice[0] + "\n");
	}
}