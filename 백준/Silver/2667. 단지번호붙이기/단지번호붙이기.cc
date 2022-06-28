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

int board[26][26];
bool vis[26][26];

vector<int> order;
queue<pair<int, int>> q;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	string temp;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		for (int j = 0; j < temp.length(); j++) {
			board[i][j] = temp[j] - '0';
		}
	}
	int area = 0, cnt = 0;

	for (int i = 0; i < N; i++) {
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

						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						if (vis[nx][ny] == 1 || board[nx][ny] == 0) continue;

						q.push({ nx, ny });
						vis[nx][ny] = 1;
					}
				}

				// bfs가 끝나면
				if (q.empty()) {
					cnt++;
					order.push_back(area);
					area = 0;
				}
			}
		}
	}
	
	cout << cnt << "\n";
	sort(order.begin(), order.end());
	for (auto k : order) {
		cout << k << "\n";
	}


	return 0;
}