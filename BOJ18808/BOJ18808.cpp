// https://www.acmicpc.net/problem/18808

/*
	- basic idea:
	빈 board 하나를 준비하고 스티커를 넣을 수 있는지 체크합니다.
	만약 삽입이 가능하다면 삽입하고, flag를 0으로 바꾸어
	그 스티커에 대한 반복을 종료하고 다른 스티커로 넘어갑니다.
	만약 삽입이 안된다면 스티커에 대한 회전함수로 들어가서 바꾸고
	회전된 모양을 삽입한 후 check_insert 로 진행합니다.

	- reference idea:
	스티커의 삽입에 대한 접근은 해답과 같았지만 rotation 에 대한
	접근이 달랐습니다. 저는 90, 180, 270도 씩 각각의 경우에 대해
	생각했었는데, 해답에서는 함수 하나로 임시로 이차원 배열을
	선언하여 90도 회전시키고 기존 배열에 대입하고, R과 C를 swap 하여
	범위를 지정하는 방식을 택했습니다.

	기존 코드를 바탕으로 해당 사이트에 나와있는 문제의 입력값을
	모두 넣어서 확인하고 제출을 했는데, 시간 초과나 다른 문제가 없고
	바로 틀렸다고 나와서 후에 다시 생각하면서 반례를 찾고 고치는 것이
	필요하다고 생각합니다.

*/

// 기존 코드

//#include <bits/stdc++.h>
//
//using namespace std;
//
//int N, M, K, R, C;
//int board[42][42]; // 전체 판
//int board2[12][12]; // 스티커 판
//int rotate_board[12][12]; // 스티커 회전판
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
//	// 다시 초기화
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
//		// 각각의 스티커 board2에 삽입
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
//		// board1과 비교해서 넣을수 있을지 없을지.
//		// 넣을 수 없다면 회전해서 넣을 수 있을지 없을지.
//
//		while (flag) {
//			// 가능한지?
//			for (int y = 0; y <= N - R; y++) {
//				for (int x = 0; x <= M - C; x++) {
//					check_insert(x, y, board2, R, C);
//					if (flag == 0) break;
//				}
//				if (flag == 0) break;
//			}
//			if (flag == 0) break;
//
//			// 회전하기
//			rotate_func(90);
//			rotate_func(180);
//			rotate_func(270);
//			flag = 0;
//
//			
//		}
//
//		/*cout << "배열의 모습입니다 ----------- \n";
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
	int temp[12][12]; // 임시 배열

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			temp[i][j] = temp_board[i][j]; // 잠시 저장
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

		// rot 는 rotation 회전 횟수 변수.
		for (int rot = 0; rot < 4; rot++) {
			bool flag = 0; // 스티커 붙이지 않은 상태로 시작.
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