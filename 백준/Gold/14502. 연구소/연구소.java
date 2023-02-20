import java.util.*;
import java.io.*;

public class Main{

	static int[][] board = new int[10][10]; // 지도
	static int[][] copy_board = new int[10][10]; // 복사 지도
	static List<int[]> canWall= new ArrayList<>(); // 벽으로 사용될 수 있는 칸
	static List<int[]> virus= new ArrayList<>(); 
	
	static int N, M; // 세로, 가로
	static int max_cnt; // 최대 값 저장
	static final int [] dx = {1, 0, -1, 0};
	static final int [] dy = {0, 1, 0, -1};
	
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
	
	static void bfs(int x, int y) {
		// 큐에 미리 받아둔 바이러스를 삽입
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) { // q가 빌 때 까지 반복
			int[] cur = q.poll();
			// 4방향 체크
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur[0];
				int ny = dy[dir] + cur[1];

				// 범위 이탈
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				// 바이러스이거나 벽일때
				if (copy_board[nx][ny] == 2 || copy_board[nx][ny] == 1) continue;

				copy_board[nx][ny] = 2;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	static void dfs(int x, int y) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;

			// 범위 이탈
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			// 바이러스이거나 벽일때
			if (copy_board[nx][ny] == 2 || copy_board[nx][ny] == 1) continue;

			copy_board[nx][ny] = 2;
			dfs(nx, ny);
		}
	}
	
	static void comb(int cnt, int start) {
		// 벽이 3개 세워지면 영역 체크
		if (cnt == 3) { 
			board_init(); // 지도 복사
			for(int[] temp : virus) {
//				bfs(temp[0], temp[1]); // 영역 체크
				dfs(temp[0], temp[1]); // 영역 체크
			}
			solve(); // 안전영역 크기구하기
			return;
		}
		
		// 벽이 3개가 아니라면 벽의 개수를 늘려가며 진행
		for(int i = start ; i < canWall.size(); i++) {
			// 벽으로 만들어주기
			board[canWall.get(i)[0]][canWall.get(i)[1]] = 1;
			comb(cnt+1, i+1);
			board[canWall.get(i)[0]][canWall.get(i)[1]] = 0;
		}
	}
	
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int index = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) canWall.add(new int[] {i, j});
				if(board[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		
		comb(0, 0);
		
		System.out.println(max_cnt);
	}
}
