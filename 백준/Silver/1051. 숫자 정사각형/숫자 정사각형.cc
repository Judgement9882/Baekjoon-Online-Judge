#include <bits/stdc++.h>
#define MAX_N 51
#define MAX_M 51
using namespace std;
int N, M;
int board[MAX_N][MAX_M];

int maxSquare(int max_num) {
	int ret = 1;
	int size = 1;
	while (++size <= max_num) {
		for (int sx = 0; sx <= N - size; sx++) {
			for (int sy = 0; sy <= M - size; sy++) {
				int num = board[sx][sy];
				if (num != board[sx + size - 1][sy]) continue;
				if (num != board[sx + size - 1][sy + size - 1]) continue;
				if (num != board[sx][sy + size - 1]) continue;
				ret = size;
			}
		}
	}
	return ret * ret;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string temp; cin >> temp;
		int len = temp.length();
		for (int j = 0; j < len; j++) {
			board[i][j] = temp[j] - '0';
		}
	}

	cout << maxSquare(min(N, M));


	return 0;
}