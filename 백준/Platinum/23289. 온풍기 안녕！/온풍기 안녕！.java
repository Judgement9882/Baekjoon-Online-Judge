import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K, W;
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	static int[][] hdx = { { -1, 0, 1 }, { 1, 0, -1 }, { -1, -1, -1 }, { 1, 1, 1 } };
	static int[][] hdy = { { 1, 1, 1 }, { -1, -1, -1 }, { 1, 0, -1 }, { -1, 0, 1 } };
	static int[][] board, wall, heatArray;
	static ArrayDeque<int[]> heater = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[R + 1][C + 1];
		List<int[]> check = new ArrayList<>();
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 5)
					check.add(new int[] { i, j });
				else if (board[i][j] != 0) { // 1, 2, 3, 4 -> 0, 1, 2, 3
					heater.offer(new int[] { i, j, board[i][j] - 1 });
				}
				board[i][j] = 0;
			}
		}

		W = Integer.parseInt(br.readLine());
		wall = new int[R + 2][C + 2];
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			// 벽의 상태 저장 -> 우좌상하 -> 비트마스킹 역순 하상좌우
			if (t == 0) {
				// x 기준 위쪽, x-1 기준 아래쪽
				wall[x][y] |= (1 << 2);
				wall[x - 1][y] |= (1 << 3);
			} else {
				// y 기준 오른쪽, y+1 기준 왼쪽
				wall[x][y] |= (1 << 0);
				wall[x][y + 1] |= (1 << 1);
			}
		}

		heatArray = new int[R + 1][C + 1];
		firstHeat();
		int choco = 0;
		while (choco <= 100) { // 100 이하일때만
//			System.out.println("before heat");
//			test();
			heat();
//			System.out.println("after heat");
//			test();
			spread();
//			System.out.println("after spread");
//			test();
			down();
//			System.out.println("after down");
//			test();
			choco++;
			if (checkNum(check))
				break;
		}
		System.out.println(choco);
		br.close();
	}

	static void firstHeat() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		while (!heater.isEmpty()) {
			int cur[] = heater.poll();
			int x = cur[0], y = cur[1], dir = cur[2];
			x += dx[dir];
			y += dy[dir]; // 온풍기에서 한칸 떨어진 위치에서 5부터 진행

			boolean[][] v = new boolean[R + 1][C + 1];
			v[x][y] = true;
			heatArray[x][y] += 5;
			q.offer(new int[] { x, y, 4 });
			while (!q.isEmpty()) {
				int[] c = q.poll();
				int hx = c[0], hy = c[1];

				// 1이면 퍼져나갈 수 없으므로 continue
				if (c[2] == 0)
					continue;

				// 온풍기 이동
				for (int d = 0; d < 3; d++) {
					int nx = hx + hdx[dir][d];
					int ny = hy + hdy[dir][d];
					// 범위 체크 및 방문체크
					if (nx < 1 || nx > R || ny < 1 || ny > C || v[nx][ny])
						continue;
					if (d == 0) { // 위
						if ((wall[hx][hy] & (1 << ((dir + 2) % 4))) == 0) {
							if ((wall[hx + dx[(dir + 2) % 4]][hy + dy[(dir + 2) % 4]] & (1 << dir)) == 0) {
								v[nx][ny] = true;
								heatArray[nx][ny] += c[2];
								q.offer(new int[] { nx, ny, c[2] - 1 });
							}
						}
					} else if (d == 1) { // 중간
						// 벽이 없으면
						if ((wall[hx][hy] & (1 << dir)) == 0) {
							v[nx][ny] = true;
							heatArray[nx][ny] += c[2];
							q.offer(new int[] { nx, ny, c[2] - 1 });
						}
					} else if (d == 2) { // 아래
						if ((wall[hx][hy] & (1 << (3 - dir))) == 0) {
							if ((wall[hx + dx[3 - dir]][hy + dy[3 - dir]] & (1 << dir)) == 0) {
								v[nx][ny] = true;
								heatArray[nx][ny] += c[2];
								q.offer(new int[] { nx, ny, c[2] - 1 });
							}
						}
					}
					
//					System.out.println("move");
//					move();
				}
			}
		}
	}

	static void heat() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				board[i][j] += heatArray[i][j];
			}
		}
	}

	static void spread() {
		int[][] tempBoard = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if (nx < 1 || nx > R || ny < 1 || ny > C)
						continue;
					// 벽이 있으면
					if ((wall[i][j] & (1 << d)) != 0) continue;
					
					
					if(board[i][j] > board[nx][ny]) { // 높은 경우만
						int minusNum = (board[i][j] - board[nx][ny]) / 4;
						tempBoard[nx][ny] += minusNum;
						tempBoard[i][j] -= minusNum;	
					}
				}
			}
		}

		// paste
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				board[i][j] += tempBoard[i][j];
				if(board[i][j] < 0) board[i][j] = 0; 
			}
		}
	}

	static void down() {
		for (int j = 1; j <= C; j++) {
			if (board[1][j] > 0)
				board[1][j]--;
			if (board[R][j] > 0)
				board[R][j]--;
		}
		for (int i = 2; i <= R - 1; i++) {
			if (board[i][1] > 0)
				board[i][1]--;
			if (board[i][C] > 0)
				board[i][C]--;
		}
	}

	static boolean checkNum(List<int[]> check) {
		for (int[] ij : check) {
			if (board[ij[0]][ij[1]] < K)
				return false;
		}
		return true;
	}
	
	static void test() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void move() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(heatArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}