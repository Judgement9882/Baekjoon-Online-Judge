/*
	https://www.acmicpc.net/problem/12100

	2048
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int board[22][22];
int test_board[22][22];

void rotate() {
	int tmp[22][22];
	
	// swap 하기위한 복사
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			tmp[i][j] = test_board[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			// 90도 회전
			test_board[i][j] = tmp[N - 1 - j][i];
		}
	}
}

void move(int dir) {
	// dir에 따른 방향 전환
	while (dir--) rotate();

	for (int i = 0; i < N; i++) {
		int check_insert_or_not[22] = {};
		int idx = 0;

		for (int j = 0; j < N; j++) {
			if (test_board[i][j] == 0) continue; // 0이 있다면 건너뜀

			// 만약 idx에 있는 칸이 0으로 아무것도 들어간게 없다면 추가
			if (check_insert_or_not[idx] == 0) {
				check_insert_or_not[idx] = test_board[i][j];
			}

			// 같다면 두배 (더해줌), 이후 idx++
			else if (check_insert_or_not[idx] == test_board[i][j]) {
				check_insert_or_not[idx++] *= 2;
			}

			// idx있는 칸에 어떤 수가 있고, 같지 않을 경우 idx++ 이후 그 칸에 넣어줌
			else{
				check_insert_or_not[++idx] = test_board[i][j];
			}
		}

		// 작업이 끝난 이후 test_board에 갱신해줌.
		for (int j = 0; j < N; j++) {
			test_board[i][j] = check_insert_or_not[j];
		}
	}
	
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}
	int max_num = 0;
	// 상 하 좌 우 4번의 경우를 각각 5번 시행하면 되므로 4^5번 비교
	for (int k = 0; k < (1 << 10); k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				test_board[i][j] = board[i][j];
			}
		}

		int temp = k;
		int five = 5;
		while (five--) {
			int dir = temp % 4;
			temp /= 4;
			move(dir);
			/*cout << "test=====\n";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cout << test_board[i][j] << " ";
				}
				cout << "\n";
			}*/
		}
		//cout << "test=====\n";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max_num = max(max_num, test_board[i][j]);
				//cout << test_board[i][j] << " ";
			}
			//cout << "\n";
		}
	}
	cout << max_num;
	return 0;
}



