#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

int R, C;
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int fire_dist[1002][1002];
int jihun_dist[1002][1002];
string board[1002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> R >> C;

	for (int i = 0; i < R; i++) {
		fill(fire_dist[i], fire_dist[i] + C, -1);
		fill(jihun_dist[i], jihun_dist[i] + C, -1);
	}

	queue<pair<int, int>> QF;
	queue<pair<int, int>> QJ;

	for (int i = 0; i < R; i++) {
		cin >> board[i];
		for (int j = 0; j < C; j++) {
			if (board[i][j] == 'F') {
				QF.push({ i, j });
				fire_dist[i][j] = 0;
				
			}
			else if (board[i][j] == 'J') {
				QJ.push({ i, j });
				jihun_dist[i][j] = 0;
			}
		}
	}

	// fire
	while (!QF.empty()) {
		auto cur = QF.front();
		QF.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + cur.X;
			int ny = dy[dir] + cur.Y;

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			if (fire_dist[nx][ny] >= 0 || board[nx][ny] == '#') continue;

			fire_dist[nx][ny] = fire_dist[cur.X][cur.Y] + 1;
			QF.push({ nx, ny });
		}

		// check
		/*
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cout << fire_dist[i][j] << " ";
			}
			cout << "\n";
		}
		*/
	}

	// jihun
	while (!QJ.empty()) {
		auto cur = QJ.front();
		QJ.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = dx[dir] + cur.X;
			int ny = dy[dir] + cur.Y;

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				cout << jihun_dist[cur.X][cur.Y]+1;
				return 0;
			}
			if (jihun_dist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
			if (fire_dist[nx][ny] != -1 && jihun_dist[cur.X][cur.Y] + 1 >= fire_dist[nx][ny]) {
				continue;
			}

			jihun_dist[nx][ny] = jihun_dist[cur.X][cur.Y] + 1;
			QJ.push({ nx, ny });
		}

		// check
		/*
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cout << jihun_dist[i][j] << " ";
			}
			cout << "\n";
		}
		*/
	}

	cout << "IMPOSSIBLE";

	return 0;
}