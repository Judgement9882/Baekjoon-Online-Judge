#include <iostream>
using namespace std;
int N, M;
char board[201][201];

void init() {
	for (int i = 0; i < N; i++) {
		string temp; cin >> temp;
		for (int j = 0; j < M; j++) {
			board[i][j] = temp[j];
		}
	}
}

bool mbti(char c1, char c2, char c3, char c4) {
	return (c1 == 'E' || c1 == 'I') && (c2 == 'N' || c2 == 'S') && (c3 == 'T' || c3 == 'F') && (c4 == 'P' || c4 == 'J') || (c1 == 'P' || c1 == 'J') && (c2 == 'F' || c2 == 'T') && (c3 == 'S' || c3 == 'N') && (c4 == 'E' || c4 == 'I');
}

int slide_hor() {
	int ret = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= M - 4; j++) {
			if (mbti(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3])) ret++;
		}
	}
	return ret;
}

int slide_ver() {
	int ret = 0;
	for (int j = 0; j < M; j++) {
		for (int i = 0; i <= N - 4; i++) {
			if (mbti(board[i][j], board[i+1][j], board[i+2][j], board[i+3][j])) ret++;
		}
	}
	return ret;
}

int slide_up() {
	int ret = 0;
	for (int i = 3; i < N; i++) {
		for (int j = 0; j <= M - 4; j++) {
			if (mbti(board[i][j], board[i-1][j+1], board[i-2][j+2], board[i-3][j + 3])) ret++;
		}
	}
	return ret;
}

int slide_down() {
	int ret = 0;
	for (int i = 0; i <= N - 4; i++) {
		for (int j = 0; j <= M - 4; j++) {
			if (mbti(board[i][j], board[i+ 1][j + 1], board[i+ 2][j + 2], board[i + 3][j + 3])) ret++;
		}
	}
	return ret;
}

void solve() {
	cin >> N >> M;
	init();
	int ans = 0;
	ans += slide_hor();
	ans += slide_ver();
	ans += slide_up();
	ans += slide_down();
	cout << ans;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	solve();
	return 0;
}