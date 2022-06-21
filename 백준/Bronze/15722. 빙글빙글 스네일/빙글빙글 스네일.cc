/*
	https://www.acmicpc.net/problem/15722

	빙글빙글 달팽이
*/

#include <iostream>

using namespace std;

int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, nx = 0, ny=0, move = 0, dist=1, dist_cnt = 0, dir=0;
	cin >> n;
	while (n--) {
		nx += dx[dir];
		ny += dy[dir];
		move++;
		if (move == dist) {
			dir = (dir + 1) % 4;
			dist_cnt++;
			if (dist_cnt == 2) {
				dist++;
				dist_cnt = 0;
			}
			move = 0;
		}
	}
	
	cout << nx << " " << ny;

	return 0;
}