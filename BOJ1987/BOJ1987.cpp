// https://www.acmicpc.net/problem/1987

/*
	R x C ���忡 ���ĺ��� ������,
	�̹� �湮�� ���ĺ��� ĭ�� �湮���� �ʴ� �ִ��� ����� ���� ���ϴ� ����.

	- ������ 1�� 1��
	- �����¿� �̵� ���� -> �迭�� ���� ����
	- �湮�� ���ĺ��� �����ϴ� �迭 ���� ->
		���ĺ��� �����Ͽ� �Ź� Ȯ���ϴ� �� ���� ( O(n) )
		26���� ���ĺ��� index�� Ȱ���Ͽ�
		���������� true, ������������ false�� �����Ͽ�
		�ش� ���ĺ��� ������ �� �� index�� Ȯ���ϸ�
		O(1) �� Ȯ���� �� �ֱ� ������ ���ĺ��� ���ڷ� ��ȯ�Ͽ� ���.

	- �ִ� �� ĭ�� �������� -> 
		dfs�� count�� �� �� ���� max �� ����,
		�ڷΰ����� count ����.
		���� ����� ĭ ���� -> dfs ���� �� count
	
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