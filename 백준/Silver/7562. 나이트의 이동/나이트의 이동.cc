/*
	https://www.acmicpc.net/problem/10026

	적록색약
	
	
*/

#include <iostream>
#include <queue>

using namespace std;

#define X first
#define Y second

int dx[8] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int dy[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };

int board[301][301];
bool vis[301][301];

queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, I, cur_x, cur_y, des_x, des_y; cin >> T;
	
	while (T--) {
		cin >> I >> cur_x >> cur_y >> des_x >> des_y;

		fill(board[0], board[0] + 301 * 301, 0);
		fill(vis[0], vis[0] + 301 * 301, 0);
		

		q.push({ cur_x, cur_y });
		vis[cur_x][cur_y] = 1;

		// 처음부터 같으면 바로 종료
		if (cur_x == des_x && cur_y == des_y) {
			cout << 0 << "\n";
			continue;
		}

		int cnt = 0, end_flag = 0;

		while (1) { // 종료조건 : des_x, des_y 도착
			cnt++;
			int queue_size = q.size();
			for (int m = 0; m < queue_size; m++) {
				pair<int, int> cur = q.front();
				q.pop();

				for (int i = 0; i < 8; i++) {
				
					int nx = dx[i] + cur.X;
					int ny = dy[i] + cur.Y;

					if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
					if (vis[nx][ny] == 1) continue;
					if (nx == des_x && ny == des_y) {
						end_flag = 1;
						break;
					}

					q.push({ nx, ny });
					vis[nx][ny] = 1;
					// cout << nx << "," << ny << "and cnt : " << queue_size << "\n";
				}
				if (end_flag) break;
			}
			if (end_flag) break;
		}

		cout << cnt << '\n';

		while (!q.empty()) q.pop();
	}
	
	return 0;
}