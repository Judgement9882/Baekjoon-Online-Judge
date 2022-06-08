/*
	https://www.acmicpc.net/problem/2476

	주사위 게임
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, a, b, c, reward, max_rew=0;
	cin >> N;
	while (N--) {
		cin >> a >> b >> c;

		if (a == b && b == c) {
			reward = 10000 + a * 1000;
		}
		else if (a == b) {
			reward = 1000 + a * 100;
		}
		else if (c == b) {
			reward = 1000 + c * 100;
		}
		else if (a == c) {
			reward = 1000 + a * 100;
		}
		else {
			reward = max(max(a, b), c) * 100;
		}

		max_rew = max(max_rew, reward);
	}
	cout << max_rew;

	return 0;
}