/*
	https://www.acmicpc.net/problem/4963

	섬
*/

#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int dx[8] = { 1, 1, 0, -1, -1, -1, 0, 1 };
int dy[8] = { 0, 1, 1, 1, 0, -1, -1, -1};

int w, h;

int board[52][52];
bool vis[52][52];

queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	while (1) {
		cin >> h >> w;

		if (h == 0 && w == 0) break;

		fill(board[0], board[0] + 52 * 52, 0);
		fill(vis[0], vis[0] + 52 * 52, 0);

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				cin >> board[i][j];
			}
		}

		int cnt = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (board[i][j] == 1 && vis[i][j] == 0) {
					q.push({ i, j });
					vis[i][j] = 1;
					cnt++;
					while (!q.empty()) {
						pair<int, int> cur = q.front();
						q.pop();

						for (int k = 0; k < 8; k++) {
							int nx = dx[k] + cur.first;
							int ny = dy[k] + cur.second;

							if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
							if (vis[nx][ny] == 1 || board[nx][ny] == 0) continue;

							q.push({ nx, ny });
							vis[nx][ny] = 1;
						}
					}
				}
			}
		}
		cout << cnt << "\n";
	}
	return 0;
}