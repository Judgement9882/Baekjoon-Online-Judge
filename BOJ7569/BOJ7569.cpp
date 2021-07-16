#include <bits/stdc++.h>

using namespace std;

int m, n, h;
int dx[6] = { 1, 0, -1, 0, 0, 0 };
int dy[6] = { 0, 1, 0, -1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, 1, -1 };

int board[102][102][102];
queue<tuple<int, int, int>> Q;
int minus_one = 0;

int main() {

	// input ====================================
	cin >> m >> n >> h;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> board[i][j][k];
				if (board[i][j][k] == 1) {
					Q.push(make_tuple(i, j, k));
				}
				if (board[i][j][k] == -1) {
					minus_one++;
				}
			}
		}
	}
	// ==========================================

	// All tomatoes are riped at first time
	if (Q.size() == m * n * h - minus_one) {
		cout << "0";
		return 0;
	}
	// ====================================

	// BFS ========================================================
	int num = 0;

	while (!Q.empty()) {
		tuple<int, int, int> cur = Q.front();
		Q.pop();

		for (int dir = 0; dir < 6; dir++) {
			int nx = get<2>(cur) + dx[dir];
			int ny = get<1>(cur) + dy[dir];
			int nz = get<0>(cur) + dz[dir];

			if (nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h) continue;
			if (board[nz][ny][nx] != 0) continue;

			board[nz][ny][nx] = board[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
			Q.push(make_tuple(nz, ny, nx));
			num = max(num, board[nz][ny][nx]);
		}

		// check the board's elements
		/*
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					cout << board[i][j][k] << " ";
				}
				cout << "\n";
			}
		}
		*/
	}
	// ===========================================================

	// check condition =====================
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (board[i][j][k] == 0) {
					cout << "-1";
					return 0;
				}
			}
		}
	}

	cout << num - 1;
	return 0;
	// =====================================
}