import java.io.*;
import java.util.*;

public class Main{
	static int N, M, R;
	static int[][] board, temp_board;

	static void One() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = board[i][j];
				board[i][j] = board[N - i - 1][j];
				board[N - i - 1][j] = temp;
			}
		}
	}

	static void Two() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = board[i][j];
				board[i][j] = board[i][M - j - 1];
				board[i][M - j - 1] = temp;
			}
		}
	}

	/*
	 * 1. N과 M이 바뀜 2. (0, 0) -> (0, N-1) (1, 0) -> (0, N-2) (2, 0) -> (0, N-3)
	 * 
	 * (N-1, M) -> (M, 0) (N-2, M) -> (M, 1)
	 */
	static void Three() {
		temp_board = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_board[j][N - i - 1] = board[i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		board = temp_board;
	}

	/*
	 * 1. N과 M이 바뀜 2. (0, 0) -> (M-1, 0) (1, 0) -> (M-1, 1) (2, 0) -> (M-1, 2)
	 * 
	 */
	static void Four() {
		temp_board = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_board[M - j - 1][i] = board[i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		board = temp_board;
	}

	static void Five() {
		temp_board = new int[N][M];

		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp_board[i + y * (N / 2)][j + (1 - x) * (M / 2)] = board[i + x * (N / 2)][j + y * (M / 2)];
					}
				}
			}
		}

		board = temp_board;
	}

	static void Six() {
		temp_board = new int[N][M];

		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp_board[i + (1-y) * (N / 2)][j + x * (M / 2)] = board[i + x * (N / 2)][j + y * (M / 2)];
					}
				}
			}
		}

		board = temp_board;
	}

	// 입력값에 따른 배열돌리기 진행
	static void func(int num) {
		if (num == 1)
			One();
		else if (num == 2)
			Two();
		else if (num == 3)
			Three();
		else if (num == 4)
			Four();
		else if (num == 5)
			Five();
		else if (num == 6)
			Six();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 배열 돌리기
		st = new StringTokenizer(br.readLine(), " ");
		while (R-- > 0) {
			func(Integer.parseInt(st.nextToken()));
		}

		// 최종 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		br.close();
	}
}
