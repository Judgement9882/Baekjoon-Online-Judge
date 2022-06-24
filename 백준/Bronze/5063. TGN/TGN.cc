/*
	https://www.acmicpc.net/problem/5063

	광고
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, r, e, c;
	cin >> N;
	while (N--) {
		cin >> r >> e >> c;
		// 광고를 안해도 될때 수익이 더 높다
		if (r > e - c) cout << "do not advertise\n";
		else if (r == e-c) cout << "does not matter\n";
		else cout << "advertise\n";
	}

	return 0;
}