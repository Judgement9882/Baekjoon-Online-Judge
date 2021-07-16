#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

// height, length
int n;
int m;

// board & visit position array
int board[502][502];
bool vis[502][502];

// direction
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int nop = 0; // the number of picture
int mba = 0; // most biggest area

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	// input part =======================
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
		}
	}
	
	// bfs ==============================
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 0 || vis[i][j]) {
				continue;
			}

			queue<pair<int, int>> Q;
			Q.push({ i, j });
			nop++;
			vis[i][j] = 1;
			int area = 0;

			while (!Q.empty()) {
				pair<int, int> cur = Q.front();
				Q.pop();
				area++;
				for (int i = 0; i < 4; i++) {
					int nx = cur.X + dx[i];
					int ny = cur.Y + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					if (vis[nx][ny] || board[nx][ny] != 1) {
						continue;
					}
					vis[nx][ny] = 1;
					Q.push({ nx, ny });
					
				}
			}
			mba = max(mba, area);

		}
	}

	cout << nop << "\n" << mba;

	return 0;
}