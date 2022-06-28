/*
	https://www.acmicpc.net/problem/2468

	안전 영역
*/

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

#define X first
#define Y second

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[101][101];
int rain[101][101];
bool vis[101][101];

queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, temp, min_height = 999, max_height = -999; cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> temp; board[i][j] = temp;
			min_height = min(min_height, temp);
			max_height = max(max_height, temp);
		}
	}

	int cnt, max_cnt = -999;

	for (int k = min_height; k <= max_height; k++) {

		// 초기화
		cnt = 0;
		while (!q.empty()) q.pop();
		fill(rain[0], rain[0] + 101 * 101, 0);
		fill(vis[0], vis[0] + 101 * 101, 0);

		// 높이에 따른 rain 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rain[i][j] = board[i][j] - k;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (vis[i][j] == 0 && rain[i][j] > 0) {
					q.push({ i, j });
					vis[i][j] = 1;
					cnt++;
					while (!q.empty()) {

						pair<int, int> cur = q.front();
						q.pop();

						for (int m = 0; m < 4; m++) {
							int nx = dx[m] + cur.X;
							int ny = dy[m] + cur.Y;

							if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
							if (vis[nx][ny] == 1 || rain[nx][ny] <= 0) continue;

							q.push({ nx, ny });
							vis[nx][ny] = 1;
						}
					}
				}
			}
		}
		max_cnt = max(cnt, max_cnt);

		// 비가 오지 않을 경우를 고려
		max_cnt = max(1, max_cnt);
	}
	cout << max_cnt;

	return 0;
}