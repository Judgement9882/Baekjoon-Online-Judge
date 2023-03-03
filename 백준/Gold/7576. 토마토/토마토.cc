#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

int n, m;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[1002][1002];
int num = 0;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<pair<int, int>> Q;
	int minus_one = 0;

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1) {
				Q.push({ i, j });
			}
			if (board[i][j] == -1) {
				minus_one++;
			}
		}
	}

	if (Q.size() == n * m - minus_one) {
		cout << "0";
		return 0;
	}

	while (!Q.empty()) {
		
		auto cur = Q.front();
		Q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cur.X;
			int ny = dy[i] + cur.Y;

			if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if (board[nx][ny] != 0 || board[nx][ny] == -1) continue;

			board[nx][ny] = board[cur.X][cur.Y] + 1;
			Q.push({ nx, ny });
			num = max(num, board[nx][ny]);
		}


		// check board array
		/*
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cout << board[i][j] << " ";
			}
			cout << "\n";
		}
		*/
	}


	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] == 0) {
				cout << "-1";
				return 0;
			}
		}
	}
	
	cout << num - 1;

	return 0;
}