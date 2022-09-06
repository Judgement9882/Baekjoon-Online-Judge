/*
	https://www.acmicpc.net/problem/6593

	상범 빌딩
*/

#include <iostream>
#include <algorithm>
#include <tuple>
#include <queue>

using namespace std;

int dx[6] = { 1, 0, -1, 0, 0, 0 };
int dy[6] = { 0, 1, 0, -1, 0, 0};
int dz[6] = { 0, 0, 0, 0, 1, -1 };

char board[32][32][32];
short vis[32][32][32];

int L, R, C;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<tuple<int, int, int>> Q;

	while (1) {
		cin >> L >> R >> C;

		// escape condition
		if (L == 0 && R == 0 && C == 0) break;

		tuple<int, int, int> des;

		for (int k = 0; k < L; k++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					
					// init
					board[k][i][j] = 0;
					vis[k][i][j] = 0;

					cin >> board[k][i][j];
					if (board[k][i][j] == 'S') {
						Q.push({ k, i, j });
						vis[k][i][j] = 1; // 방문
					}
					else if (board[k][i][j] == '#') vis[k][i][j] = 1;
					else if (board[k][i][j] == 'E') des = { k, i, j };
				}
			}
		}

		int end_flag = 0;

		while (!Q.empty()) {
			tuple<int, int, int> cur = Q.front(); Q.pop();
			
			for (int dir = 0; dir < 6; dir++) {
				int nx = get<1>(cur) + dx[dir];
				int ny = get<2>(cur) + dy[dir];
				int nz = get<0>(cur) + dz[dir];

				if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
				if (vis[nz][nx][ny] != 0 || board[nz][nx][ny] == '#') continue;

				// 탈출지점이라면
				if (get<0>(des) == nz && get<1>(des) == nx && get<2>(des) == ny) {
					cout << "Escaped in " << vis[get<0>(cur)][get<1>(cur)][get<2>(cur)] << " minute(s).\n";
					while (!Q.empty()) Q.pop();
					end_flag = 1;

					// test
					/*for (int k = 0; k < L; k++) {
						for (int i = 0; i < R; i++) {
							for (int j = 0; j < C; j++) {
								cout << vis[k][i][j] << " ";
							}
							cout << "\n";
						}
						cout << "\n\n";
					}*/
					// test

					break;
				}

				Q.push({ nz, nx, ny });
				vis[nz][nx][ny] = vis[get<0>(cur)][get<1>(cur)][get<2>(cur)]+1;
				//test
				/*cout << "좌표는 : " << nx << ny << nz << "이다\n";*/
				//test
			}
		}
		if (end_flag == 0) cout << "Trapped!\n";
	}
	return 0;
}
