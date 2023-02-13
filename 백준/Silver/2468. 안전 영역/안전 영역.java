import java.io.*;
import java.util.*;

public class Main{
	static StringBuilder sb = new StringBuilder();
	// 방향 설정
	static final int []dx = {1, 0, -1, 0};
	static final int []dy = {0, 1, 0, -1};
	static int max_piece = 1, N, day; // 변수 설정
	static int [][] board; // 치즈 일 수 배열
	static boolean [][] v; // 방문 표시 배열
	
	// dfs
	static void dfs(int x, int y) {
		v[x][y] = true; // 방문표시
		for(int dir = 0 ; dir < 4; dir++) { // 네 방향 확인
			int nx = x + dx[dir]; // 새로운 x
			int ny = y + dy[dir]; // 새로운 y
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위 벗어났는지 확인
			if(board[nx][ny] <= day || v[nx][ny]) continue; // day보다 작거나 같고, 방문했다면 continue
			dfs(nx, ny); // 다시 dfs
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력
		max_piece = 1; // 최대값 초기화(0일차에는 한덩이로 있기 때문에 1로 초기화)
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N]; // 치즈 일자 배열
		
		// 입력
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ;j < N ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		day = 1; // 1일차부터 시작
		while(day <= 100) { // 100일까지
			int num = 0; // 최대 덩이수
			v = new boolean[N][N]; // 방문 배열 초기화
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ;j < N ; j++) {
					if(board[i][j] > day && !v[i][j]) // day보다 크거나 방문 안한경우
					{
						dfs(i, j); // dfs
						num++; // 덩이수 추가
					}
				}
			}
			if(num == 0) break; // 만약 덩이가 0이라면 다먹은것
			max_piece = Math.max(max_piece, num); // 갱신
			day++; // 날짜 수 증가
		}
		System.out.println(max_piece);
		br.close();
	}
}
