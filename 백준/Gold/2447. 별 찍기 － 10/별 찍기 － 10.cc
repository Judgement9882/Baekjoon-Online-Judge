/*
	https://www.acmicpc.net/problem/2447

	별찍기 10
*/

#include <iostream>
#include <algorithm>

using namespace std;

int N;
char board[2200][2200];



void func(int x, int y, int num) {
	
	if (num == 1) {
		board[x][y] = '*';
		return;
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (i == 1 && j == 1) continue;
			func(x + i * num / 3, y + j * num / 3, num / 3);
		}
	}
	
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		fill(board[i], board[i] + N, ' ');
	}


	func(0, 0, N);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << board[i][j];
		}
		cout << "\n";
	}

	return 0;
}
