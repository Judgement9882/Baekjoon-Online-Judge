#include <bits/stdc++.h>
using namespace std;

void kaying(int M, int N, int x, int y) {

	// i % N -> 나올수 있는 범위 : 0~N-1 까지.

	if (x == M) x = 0;
	if (y == N) y = 0;

	for (int i = x; i <= M * N; i += M) {
		if (i % N == y) {
			cout << i << "\n";
			return;
		}
	}
	cout << -1 << "\n";
	return;
}

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int T;
	cin >> T;
	while (T--) {
		int M, N, x, y;
		cin >> M >> N >> x >> y;
		kaying(M, N, x, y);
	}


	return 0;
}