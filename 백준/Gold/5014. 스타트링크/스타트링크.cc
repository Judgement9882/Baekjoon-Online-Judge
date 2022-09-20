/*
	https://www.acmicpc.net/problem/5014

	스타트링크
*/

#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int F, S, G, U, D;

int tall[1000002];

bool OOB(int nx) {
	return nx <= 0 || nx > F;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	queue<int> move;

	cin >> F >> S >> G >> U >> D;

	// 같은 층
	if (S == G) {
		cout << 0;
		return 0;
	}

	move.push(S);
	tall[S] = 1;
	
	while (!move.empty()) {
		int cur = move.front();
		move.pop();

		for (auto k : { U, -D }) {
			int nx = cur + k;

			// 범위 밖
			if (OOB(nx)) continue;

			// 이미 방문한 곳이라면
			if (tall[nx] != 0) continue;
			
			if (nx == G) {
				cout << tall[cur];
				return 0;
			}

			tall[nx] = tall[cur] + 1;
			move.push(nx);
			//cout << "nx : " << nx << "\n";
		}
	}
	cout << "use the stairs";

	return 0;
}
