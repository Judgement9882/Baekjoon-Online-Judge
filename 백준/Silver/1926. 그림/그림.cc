/*
	https://www.acmicpc.net/problem/14501

	BFS 연습
*/

#include <iostream>
#include <algorithm>
#include <utility>
#include <queue>

#define X first
#define Y second

using namespace std;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[502][502];
bool vis[502][502];

int n, m;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
		}
	}

	queue<pair<int, int>> Q;

	int total_cnt = 0;
	int max_cnt = 0;
	

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int temp_cnt = 0;
			// 1일 경우 Q에 넣고 돌리기
			if (vis[i][j] == 0 && board[i][j] == 1) { 
				vis[i][j] = 1;
				Q.push({ i, j });
				temp_cnt++;
				total_cnt++;
			}
			
			while (!Q.empty()) {

				pair<int, int> cur = Q.front(); Q.pop();

				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if (vis[nx][ny] || board[nx][ny] != 1) continue;

					Q.push({ nx, ny });
					vis[nx][ny] = 1;
					temp_cnt++;
				}
			}

			max_cnt = max(max_cnt, temp_cnt);
		}
	}

	
	cout << total_cnt << "\n" << max_cnt;



	return 0;
}
