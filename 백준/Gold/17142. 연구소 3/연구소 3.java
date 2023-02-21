import java.util.*;
import java.io.*;

public class Main{

	static int[][] board; // 지도
	static int[][] copy_board; // 복사 지도
	static List<int[]> virus = new ArrayList<>();

	static int N, M; // 세로, 가로
	static int ans; // 정답
	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	// 지도를 복사하는 함수
	static void board_init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 음수로 변환하여 복사 => 활성화 바이러스는 양수가 됨
				copy_board[i][j] = -board[i][j];
			}
		}
	}

	// 안전 영역 크기 구하기 (0 세기)
	static void solve() {
		int max_time = 0;
		
		// 비활성화 바이러스의 시간을 없애기위해 모두 2로 바꿈
		for (int[] temp : virus) copy_board[temp[0]][temp[1]] = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 안퍼진 칸이 있다면
				if(copy_board[i][j] == 0) return;
				// 최대 시간 측정
				max_time = Math.max(max_time, copy_board[i][j]);
			}
		}
		
		ans = Math.min(ans, max_time-2);
	}

	static void bfs() {
		// 큐에 미리 받아둔 바이러스를 삽입
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int[] temp : virus) {
			// 2는 활성화 바이러스
			if(copy_board[temp[0]][temp[1]] == 2) {
				q.offer(new int[] {temp[0], temp[1]});
			}
		}

		// -2 : 비활성화 바이러스
		// -1 벽
		// 0 이동가능
		
		while (!q.isEmpty()) { // q가 빌 때 까지 반복
			int[] cur = q.poll();
			// 4방향 체크
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur[0];
				int ny = dy[dir] + cur[1];

				// 범위 이탈
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				// 벽일때, 이미 퍼진 칸 or 활성화 바이러스면(2)
				if (copy_board[nx][ny] == -1 || copy_board[nx][ny] > 0)
					continue;

				copy_board[nx][ny] = copy_board[cur[0]][cur[1]] + 1;
				q.offer(new int[] { nx, ny });
			}
		}
	}

	static void comb(int cnt, int start) {
		// M개 바이러스 활성화 시
		if (cnt == M) {
			board_init(); // 지도 복사
			bfs(); // 영역 체크
			solve(); // 안전영역 크기구하기
			return;
		}

		// 바이러스 활성화
		for (int i = start; i < virus.size(); i++) {
			// 활성화 시 음수로 바꿈
			board[virus.get(i)[0]][virus.get(i)[1]] *= -1;
			comb(cnt + 1, i + 1);
			board[virus.get(i)[0]][virus.get(i)[1]] *= -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		board = new int[N][N];
		copy_board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		comb(0, 0);

		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}
}
