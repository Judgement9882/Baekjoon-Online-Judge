import java.util.*;
import java.io.*;

public class Main{
	static int R, C, T;
	static int[][] board, dust;
	static int[][] cleaningMachine = new int[2][];
	static final int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	static boolean checkRange(int nx, int ny) {
		if(nx < 0 || nx >= R || ny < 0 || ny >= C) return true;
		return false;
	}

	static void spread() {
		dust = new int[R][C]; // 먼지 배열 초기화

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] >= 5) { // 5이상이면 확산 가능
					int temp_dust = board[i][j] / 5;

					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];

						if (checkRange(nx, ny))
							continue;
						if (board[nx][ny] == -1)
							continue;

						dust[nx][ny] += temp_dust; // 새로운곳에 더함
						dust[i][j] -= temp_dust; // 기존꺼는 뺌
					}
				}
			}
		}

		// 기존 배열과 합침
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] += dust[i][j];
			}
		}
	}

	static void clean() {
		// 위에있는 공기청정기
		int x = cleaningMachine[0][0] - 1; // 어차피 처음먼지는 빨려들어감
		int y = cleaningMachine[0][1];

		int dir = 0;
		while (true) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;
			
			// 경계 밖이거나 공기청정기 보다 더 내려가는 경우
			if (checkRange(nx, ny) || nx > cleaningMachine[0][0]) {
				dir = (dir + 1) % 4;
				continue;
			}
			// 다음이 공기청정기인 경우
			if(board[nx][ny] == -1) {
				board[x][y] = 0; // 깨끗한 바람이 나옴
				break;
			}
			
			// 바람이 분다
			board[x][y] = board[nx][ny];
			x = nx;
			y = ny;
		}

		x = cleaningMachine[1][0]+1; // 어차피 처음 먼지는 빨려들어감
		y = cleaningMachine[1][1];
		
		dir = 2;
		while (true) {
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;
			// 경계 밖이거나 공기청정기 보다 더 올라가는 경우
			if (checkRange(nx, ny) || nx < cleaningMachine[1][0]) {
				dir = (dir + 3) % 4;
				continue;
			}
			
			// 다음이 공기청정기인 경우
			if(board[nx][ny] == -1) {
				board[x][y] = 0; // 깨끗한 바람이 나옴
				break;
			}
			
			// 바람이 분다
			board[x][y] = board[nx][ny];
			x = nx;
			y = ny;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 변수 설정
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		// 판 설정
		board = new int[R][C];

		int clean_index = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기 좌표 입력
				if (board[i][j] == -1) {
					cleaningMachine[clean_index++] = new int[] { i, j };
				}
			}
		}

		while (T-- > 0) {
			spread(); // 확산
			clean(); // 청소
		}

		int dust_sum = 0; // 먼지 총합
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == -1)
					continue;
				dust_sum += board[i][j];
			}
		}
		System.out.println(dust_sum);
	}
}
