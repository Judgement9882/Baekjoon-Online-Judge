/*
	https://www.acmicpc.net/problem/5427

	불
*/

#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

#define X first
#define Y second

using namespace std;

int T, w, h;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

string board[1002];
int dist_fire[1002][1002];
int dist[1002][1002];


bool OOB(int nx, int ny) {
	return nx < 0 || ny < 0 || nx >= w || ny >= h;
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<pair<int, int>> fire;
	queue<pair<int, int>> sang;

	cin >> T;
	while (T--) {
		
		cin >> h >> w;
		
		for (int i = 0; i < w; i++) {
			fill(dist_fire[i], dist_fire[i] + h, -1);
			fill(dist[i], dist[i] + h, -1);
		}

		for (int i = 0; i < w; i++) {
			cin >> board[i];
			for (int j = 0; j < h; j++) {				
				if (board[i][j] != '#') {
					if (board[i][j] == '@') {
						sang.push({ i, j });
						dist[i][j] = 0;
					}
					else if (board[i][j] == '*') {
						fire.push({ i, j });
						dist_fire[i][j] = 0;
					}
				}
			}
		}
		
		// 불의 이동
		while (!fire.empty()) {
			pair<int, int> cur = fire.front();
			fire.pop();
			
			for(int i = 0 ; i < 4; i++){
				int nx = dx[i] + cur.X;
				int ny = dy[i] + cur.Y;

				if (OOB(nx, ny)) continue;
				if (board[nx][ny] == '#' || dist_fire[nx][ny] >= 0) continue;

				dist_fire[nx][ny] = dist_fire[cur.X][cur.Y] + 1;
				fire.push({ nx, ny });
			}
		}
		
		bool esc = 0;
		while (!sang.empty()) {
			pair<int, int> cur = sang.front();
			sang.pop();

			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur.X;
				int ny = dy[dir] + cur.Y;

				// 탈출 성공
				if (OOB(nx, ny)) {
					cout << dist[cur.X][cur.Y]+1 << "\n";
					esc = 1;
					break;
				}
				
				// 벽이거나 방문했던곳 continue
				if (board[nx][ny] == '#' || dist[nx][ny] >= 0) continue;	
				if (dist_fire[nx][ny] != -1 && dist_fire[nx][ny] <= dist[cur.X][cur.Y] + 1) continue;
				dist[nx][ny] = dist[cur.X][cur.Y] + 1;
				sang.push({ nx, ny });
				
			}
			if (esc) break;
		}
		if(!esc) cout << "IMPOSSIBLE\n";

		while (!sang.empty()) sang.pop();
		while (!fire.empty()) fire.pop();

	
	}

	return 0;
}