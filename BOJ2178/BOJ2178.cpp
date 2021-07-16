/*
	BOJ 2178
	https://www.acmicpc.net/problem/2178
*/

#include <bits/stdc++.h>

#define X first
#define Y second

using namespace std;

// height & length
int n, m;

// board & distance array
int board[102][102];
int dist[102][102];

// direction
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	// input part ==============================
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		string temp;
		cin >> temp;

		for (int j = 0; j < m; j++) {
			board[i][j] = temp[j] - '0';
			dist[i][j] = -1;
		}
	}
	
	// bfs =====================================

	queue<pair<int, int>> Q;
	dist[0][0] = 1;
	Q.push({ 0, 0 });

	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (board[nx][ny] == 0 && dist[nx][ny] == -1) {
				continue;
			}

			if (dist[nx][ny] == -1) {
				dist[nx][ny] = dist[cur.X][cur.Y] + 1;
				Q.push({ nx, ny });
			}
		}

		// check the dist array
		/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cout << dist[i][j] << " ";
			}
			cout << "\n";
		}
		cout << "\n";
		*/
	}

	cout << dist[n - 1][m - 1];

	return 0;
}