/*
	https://www.acmicpc.net/problem/1012

	유기농 배추
	
	
*/

#include <iostream>
#include <queue>
#include <utility>

using namespace std;

#define X first
#define Y second

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

bool board[51][51];
bool vis[51][51];

queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, M, N, K, temp_x, temp_y; cin >> T;
	while (T--) {
		cin >> M >> N >> K;
		

		// 배추 입력
		for (int i = 0; i < K; i++) {
			cin >> temp_x >> temp_y;
			board[temp_x][temp_y] = 1;
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && vis[i][j] == 0) {
					q.push({ i,j });
					vis[i][j] = 1;

					while (!q.empty()) {
						pair<int, int> cur = q.front();
						q.pop();

						for (int k = 0; k < 4; k++) {
							int nx = cur.X + dx[k];
							int ny = cur.Y + dy[k];

							// 범위 넘어가면 돌아가기
							if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
							// 방문했거나 1이 아니면 돌아가기
							if (vis[nx][ny] == 1 || board[nx][ny] == 0) continue;

							q.push({ nx, ny });
							vis[nx][ny] = 1;
						}
					}
					cnt++;
				}	
			}
		}

		// 다시 초기화
		fill(board[0], board[0] + 51*51,0);
		fill(vis[0], vis[0] + 51*51, 0);
		
		cout << cnt << "\n";
	}

	return 0;
}