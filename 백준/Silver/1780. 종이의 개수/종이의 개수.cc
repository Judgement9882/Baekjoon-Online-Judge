/*
	https://www.acmicpc.net/problem/1780

	종이 개수
*/

#include <iostream>
#include <algorithm>

using namespace std;

int N, minus_cnt=0, zero_cnt = 0, one_cnt=0;
int board[2200][2200];

bool check(int x, int y, int n) {
	for (int i = x; i < x + n; i++) {
		for (int j = y; j < y + n; j++) {
			// 다를경우
			if (board[x][y] != board[i][j]) return false;
		}
	}
	return true;
}

void func(int x, int y, int num) {

	// 탈출조건
	if (check(x, y, num)) {
		if (board[x][y] == -1) minus_cnt++;
		else if (board[x][y] == 0) zero_cnt++;
		else one_cnt++;
		return;
	}

	// 다를경우 쪼개서 진행
	for (int m = 0; m < 3; m++) {
		for (int n = 0; n < 3; n++) {
			func(x + m * num / 3, y + n * num / 3, num / 3);
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
	cout << minus_cnt << "\n" << zero_cnt << "\n" << one_cnt;
	return 0;
}
