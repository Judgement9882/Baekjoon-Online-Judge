/*
	https://www.acmicpc.net/problem/23841

	데칼코마니
*/

#include <iostream>
#include <stack>
#include <string>

using namespace std;

char board[52][52];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M; cin >> N >> M;

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;

		for (int j = 0; j < M; j++) {
			board[i][j] = temp[j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++){
			if (board[i][j] != '.') {
				board[i][M - j - 1] = board[i][j];
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << board[i][j];
		}
		cout << "\n";
	}
	return 0;
}