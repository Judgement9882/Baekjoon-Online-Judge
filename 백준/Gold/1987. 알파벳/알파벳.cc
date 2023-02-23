// https://www.acmicpc.net/problem/1987

/*
	R x C 보드에 알파벳이 들어갔을때,
	이미 방문한 알파벳의 칸은 방문하지 않는 최대의 경우의 수를 구하는 문제.

	- 시작은 1행 1열
	- 


*/
#include <bits/stdc++.h>

using namespace std;

int board[22][22];
// bool vis[22][22];
bool alpha_vis[28];
int R, C;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int cnt, mx;

void dfs(int y, int x) {
	// vis[y][x] = true;
	alpha_vis[board[y][x]] = true;
	mx = max(mx, cnt);

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= 1 && nx <= C && ny >= 1 && ny <= R) {
			// vis[ny][nx] == false && 
			if (alpha_vis[board[ny][nx]] == false) {
				cnt++;
				dfs(ny, nx);
				cnt--;
				alpha_vis[board[ny][nx]] = false;
				// vis[ny][nx] == false;
			}
		}
	}
}


int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> R >> C;
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			char temp;
			cin >> temp;
			board[i][j] = temp - 64; // char -> int
		}
	}

	cnt++;
	dfs(1, 1);
	cout << mx;
	return 0;
}