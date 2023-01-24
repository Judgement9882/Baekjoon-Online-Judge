import java.util.*;
import java.io.*;

public class Main {

	static int[][] board = new int[10][10]; // 지도
	static int[][] copy_board = new int[10][10]; // 복사 지도
	static int[][] isused = new int[10][10]; // 유무 판별
	static int N, M; // 세로, 가로
	static int max_cnt; // 최대 값 저장
	static final int [] dx = {1, 0, -1, 0};
	static final int [] dy = {0, 1, 0, -1};
	// 좌표를 저장할 Node 클래스 정의
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	// 지도를 복사하는 함수
	static void board_init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy_board[i][j] = board[i][j];
			}
		}
	}
	
	// 안전 영역 크기 구하기 (0 세기)
	static void solve() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy_board[i][j] == 0) cnt++;
			}
		}
		max_cnt = Math.max(max_cnt, cnt);
	}
	
	static void func(int k) {
		// 벽이 3개 세워지면 영역 체크
		if (k == 3) { 
			
			board_init(); // 지도 복사
			
			// 큐에 미리 받아둔 바이러스를 삽입
			Queue<Node> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy_board[i][j] == 2) {
						queue.add(new Node(i, j));
					}
				}
			}
			
			while(!queue.isEmpty()) { // q가 빌 때 까지 반복
				Node cur = queue.peek();
				queue.poll();
				
				// 4방향 체크
				for (int dir = 0; dir < 4; dir++) {
					int nx = dx[dir] + cur.x;
					int ny = dy[dir] + cur.y;

					// 범위 이탈
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					// 바이러스이거나 벽일때
					if (copy_board[nx][ny] == 2 || copy_board[nx][ny] == 1) continue;

					copy_board[nx][ny] = 2;
					queue.add(new Node(nx, ny));
				}
			}

			solve();
			
			return;
		}
		
		
		// 벽이 3개가 아니라면 벽의 개수를 늘려가며 진행
		for(int i = 0; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				
				// 사용하지 않은 칸이며, 0이여야함.
				if(isused[i][j] == 0 && board[i][j] == 0) {
					isused[i][j] = 1;
					board[i][j] = 1;
					func(k+1);
					
					// 사용하고 나서 다시 원래대로.
					isused[i][j] = 0;
					board[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int index = 0;
		// 지도 모양 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0); // 백트래킹 시작
		
		System.out.println(max_cnt);
	}

}
