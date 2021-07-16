// https://www.acmicpc.net/problem/18808

/*
	- basic idea:
	�� board �ϳ��� �غ��ϰ� ��ƼĿ�� ���� �� �ִ��� üũ�մϴ�.
	���� ������ �����ϴٸ� �����ϰ�, flag�� 0���� �ٲپ�
	�� ��ƼĿ�� ���� �ݺ��� �����ϰ� �ٸ� ��ƼĿ�� �Ѿ�ϴ�.
	���� ������ �ȵȴٸ� ��ƼĿ�� ���� ȸ���Լ��� ���� �ٲٰ�
	ȸ���� ����� ������ �� check_insert �� �����մϴ�.

	- reference idea:
	��ƼĿ�� ���Կ� ���� ������ �ش�� �������� rotation �� ����
	������ �޶����ϴ�. ���� 90, 180, 270�� �� ������ ��쿡 ����
	�����߾��µ�, �ش信���� �Լ� �ϳ��� �ӽ÷� ������ �迭��
	�����Ͽ� 90�� ȸ����Ű�� ���� �迭�� �����ϰ�, R�� C�� swap �Ͽ�
	������ �����ϴ� ����� ���߽��ϴ�.

	���� �ڵ带 �������� �ش� ����Ʈ�� �����ִ� ������ �Է°���
	��� �־ Ȯ���ϰ� ������ �ߴµ�, �ð� �ʰ��� �ٸ� ������ ����
	�ٷ� Ʋ�ȴٰ� ���ͼ� �Ŀ� �ٽ� �����ϸ鼭 �ݷʸ� ã�� ��ġ�� ����
	�ʿ��ϴٰ� �����մϴ�.

*/

// ���� �ڵ�

//#include <bits/stdc++.h>
//
//using namespace std;
//
//int N, M, K, R, C;
//int board[42][42]; // ��ü ��
//int board2[12][12]; // ��ƼĿ ��
//int rotate_board[12][12]; // ��ƼĿ ȸ����
//int flag = 1;
//
//void check_insert(int x, int y, int arr[][12], int _R, int _C);
//
//void rotate_func(int n) {
//	if (n == 90) {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				rotate_board[j][R-1-i] = board2[i][j];
//			}
//		}
//
//		/*for (int a = 0; a < C; a++) {
//			for (int b = 0; b < R; b++) {
//				cout << rotate_board[a][b] << " ";
//			}
//			cout << '\n';
//		}*/
//
//		for (int y = 0; y <= N - C; y++) {
//			for (int x = 0; x <= M - R; x++) {
//				check_insert(x, y, rotate_board, C, R);
//			}
//		}
//	}
//	else if (n == 180) {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				rotate_board[R-1-i][C-1-j] = board2[i][j];
//			}
//		}
//		for (int y = 0; y <= N - R; y++) {
//			for (int x = 0; x <= M - C; x++) {
//				check_insert(x, y, rotate_board, R, C);
//			}
//		}
//	}
//	else if (n == 270) {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				rotate_board[C-1-j][i] = board2[i][j];
//			}
//		}
//		for (int y = 0; y <= N - C; y++) {
//			for (int x = 0; x <= M - R; x++) {
//				check_insert(x, y, rotate_board, C, R);
//			}
//		}
//	}
//
//	// �ٽ� �ʱ�ȭ
//	for (int i = 0; i < 12; i++) {
//		for (int j = 0; j < 12; j++) {
//			rotate_board[i][j] = 0;
//		}
//	}
//}
//
//void check_insert(int x, int y, int arr[][12], int _R, int _C){
//	for (int i = 0; i < _R; i++) {
//		for (int j = 0; j < _C; j++) {
//			if ((arr[i][j]) && (board[y + i][x + j])) return;
//		}
//	}
//
//	for (int i = 0; i < _R; i++) {
//		for (int j = 0; j < _C; j++) {
//			if (arr[i][j] == 1) {
//				board[y + i][x + j] = 1;
//			}
//		}
//	}
//	flag = 0;
//	return;
//}
//
//
//int main() {
//
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	cin >> N >> M >> K;
//	while (K--) {
//		// ������ ��ƼĿ board2�� ����
//		cin >> R >> C;
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				cin >> board2[i][j];
//			}
//		}
//
//
//		flag = 1;
//
//		// board1�� ���ؼ� ������ ������ ������.
//		// ���� �� ���ٸ� ȸ���ؼ� ���� �� ������ ������.
//
//		while (flag) {
//			// ��������?
//			for (int y = 0; y <= N - R; y++) {
//				for (int x = 0; x <= M - C; x++) {
//					check_insert(x, y, board2, R, C);
//					if (flag == 0) break;
//				}
//				if (flag == 0) break;
//			}
//			if (flag == 0) break;
//
//			// ȸ���ϱ�
//			rotate_func(90);
//			rotate_func(180);
//			rotate_func(270);
//			flag = 0;
//
//			
//		}
//
//		/*cout << "�迭�� ����Դϴ� ----------- \n";
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				cout << board[i][j] << " ";
//			}
//			cout << "-----------------------\n";
//		}*/
//
//	}
//
//	int cnt = 0;
//
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < M; j++) {
//			if (board[i][j] == 1) {
//				cnt++;
//			}
//		}
//	}
//	cout << cnt;
//	return 0;
//}

#include <bits/stdc++.h>

using namespace std;

int N, M, K, R, C;
int board[40][40];
int temp_board[12][12];

void rotate() {
	int temp[12][12]; // �ӽ� �迭

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			temp[i][j] = temp_board[i][j]; // ��� ����
		}
	}

	for (int i = 0; i < C; i++) {
		for (int j = 0; j < R; j++) {
			temp_board[i][j] = temp[R - 1 - j][i];
		}
	}
	swap(R, C);
}

bool check_insert(int x, int y) {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (temp_board[i][j] && board[i + x][j + y]) return 0;
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (temp_board[i][j] == 1) board[i + x][j + y] = 1;
		}
	}
	return 1;
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M >> K;
	while (K--) {
		cin >> R >> C;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cin >> temp_board[i][j];
			}
		}

		// rot �� rotation ȸ�� Ƚ�� ����.
		for (int rot = 0; rot < 4; rot++) {
			bool flag = 0; // ��ƼĿ ������ ���� ���·� ����.
			for (int x = 0; x <= N - R; x++) {
				if (flag) break;
				for (int y = 0; y <= M - C; y++) {
					if (check_insert(x, y)) {
						flag = 1;
						break;
					}
				}
			}

			if (flag) break;
			rotate();
		}
	}
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 1) cnt++;
		}
	}
	cout << cnt;
	return 0;
}