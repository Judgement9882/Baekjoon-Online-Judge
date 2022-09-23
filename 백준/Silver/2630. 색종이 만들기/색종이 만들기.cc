/*
	https://www.acmicpc.net/problem/2630

	색종이 만들기
*/

#include <iostream>
#include <algorithm>

using namespace std;

int N, white = 0, blue = 0;
int board[150][150];

bool check(int x, int y, int num) {
	for (int i = x; i < x + num; i++) {
		for (int j = y; j < y + num; j++) {
			if (board[x][y] != board[i][j]) return false;
		}
	}
	return true;
}

void func(int x, int y, int num) {
	if (check(x, y, num)) {
		if (board[x][y] == 0) white++;
		else if (board[x][y] == 1) blue++;
		return;
	}

	// 다를경우
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			func(x + i * num / 2, y + j * num / 2, num / 2);
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

	func(0, 0, N);
	cout << white << "\n" << blue;

	return 0;
}
