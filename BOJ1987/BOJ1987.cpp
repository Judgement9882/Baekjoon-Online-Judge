// https://www.acmicpc.net/problem/1987

/*
	R x C 보드에 알파벳이 들어갔을때,
	이미 방문한 알파벳의 칸은 방문하지 않는 최대의 경우의 수를 구하는 문제.

	- 시작은 1행 1열
	- 상하좌우 이동 가능 -> 배열로 방향 구현
	- 방문한 알파벳을 저장하는 배열 생성 ->
		알파벳을 저장하여 매번 확인하는 것 보다 ( O(n) )
		26개의 알파벳을 index로 활용하여
		지나왔으면 true, 안지나갔으면 false로 저장하여
		해당 알파벳을 만났을 때 그 index를 확인하면
		O(1) 로 확인할 수 있기 때문에 알파벳을 숫자로 변환하여 사용.

	- 최대 몇 칸을 지나는지 -> 
		dfs로 count를 할 때 마다 max 값 저장,
		뒤로갈때는 count 감소.
		좌측 상단의 칸 포함 -> dfs 시작 전 count
	
*/

#include <bits/stdc++.h>

using namespace std;


int board[22][22]; 
bool alpha_vis[28]; // alphabet visit

// direction
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int R, C, cnt, mx;

void dfs(int y, int x) {
	
	alpha_vis[board[y][x]] = true; // alphabet index manage
	mx = max(mx, cnt);

	// directoin part
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		// check range validity
		if (nx >= 1 && nx <= C && ny >= 1 && ny <= R) {
			
			// check alphabet visit
			if (alpha_vis[board[ny][nx]] == false) {
				cnt++;
				dfs(ny, nx);
				cnt--;
				alpha_vis[board[ny][nx]] = false;
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
			board[i][j] = temp - 64; 
			// char -> int, A = 65(ASCII)
		}
	}

	cnt++; // first time count
	dfs(1, 1);
	cout << mx;
	return 0;
}