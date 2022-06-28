/*
	https://www.acmicpc.net/problem/2583

	영역 구하기
*/

#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

using namespace std;

#define X first
#define Y second

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[101][101];
bool vis[101][101];

vector<int> order;
int cnt = 0, area = 0;
queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	fill(board[0], board[0] + 101 * 101, 1);

	int M, N, K; cin >> N >> M >> K; // x, y 편의를 위해 M, N 입력순서를 바꿈
	int start_x, start_y, end_x, end_y;
	while (K--) {
		cin >> start_x >> start_y >> end_x >> end_y;
		for (int i = start_x; i < end_x; i++) {
			for (int j = start_y; j < end_y; j++) {
				board[i][j] = 0;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (vis[i][j] == 0 && board[i][j] > 0) {
				q.push({ i, j });
				vis[i][j] = 1;

				while (!q.empty()) {
					pair<int, int> cur = q.front();
					q.pop();
					area++;
					for (int k = 0; k < 4; k++) {
						int nx = dx[k] + cur.X;
						int ny = dy[k] + cur.Y;

						if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
						if (vis[nx][ny] == 1 || board[nx][ny] == 0) continue;

						q.push({ nx, ny });
						vis[nx][ny] = 1;
					}

					// bfs가 더이상 진행이 안되면
					if (q.empty()) {
						cnt++;
						order.push_back(area);
						area = 0;
					}
				}
			}
		}
	}

	cout << cnt << "\n";
	sort(order.begin(), order.end());
	for (auto k : order) {
		cout << k << " ";
	}


	return 0;
}