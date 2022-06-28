/*
	https://www.acmicpc.net/problem/10026

	적록색약
	
	
*/

#include <iostream>
#include <queue>

using namespace std;

#define X first
#define Y second

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[101][101];
bool vis[101][101];
int board_rgb[101][101];
bool vis_rgb[101][101];

queue<pair<int, int>> q;
char same_color = 'H';

int bfs(int N, int use_board[101][101], bool use_vis[101][101]) {
	int cnt = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			// 방문하지 않았고 same_color가 아니라면
			if (use_vis[i][j] == 0 && same_color != use_board[i][j]) {
				use_vis[i][j] = 1;
				same_color = use_board[i][j];
				q.push({ i, j });

				while (!q.empty()) {
					pair<int, int> cur = q.front();
					q.pop();

					for (int k = 0; k < 4; k++) {
						int nx = dx[k] + cur.X;
						int ny = dy[k] + cur.Y;

						// 범위 이탈
						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

						// 조건 불충족
						if (use_vis[nx][ny] == 1 || use_board[nx][ny] != same_color) continue;

						q.push({ nx, ny });
						use_vis[nx][ny] = 1;
					}
				}

				cnt++;
				same_color = 'H'; // 초기화
			}
		}
	}
	return cnt;
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	string temp;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		for (int j = 0; j < temp.length(); j++) {
			board[i][j] = temp[j];
			if (temp[j] == 'G') board_rgb[i][j] = 'R';
			else board_rgb[i][j] = temp[j];
		}
	}

	// 적록색약이 아닌사람
	cout << bfs(N, board, vis) << " ";
	

	// 적록색약
	cout << bfs(N, board_rgb, vis_rgb);
	
	return 0;
}