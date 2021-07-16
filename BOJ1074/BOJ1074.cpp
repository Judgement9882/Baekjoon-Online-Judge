#include <bits/stdc++.h>

using namespace std;

int func(int _N, int _r, int _c) {
	if (_N == 0) {
		return 0;
	}

	int half = 1 << (_N - 1); // 2^(N-1)
	if (_r < half && _c < half) return func(_N - 1, _r, _c);
	if (_r < half && _c >= half) return half*half + func(_N - 1, _r, _c - half);
	if (_r >= half && _c < half) return 2*half*half + func(_N - 1, _r - half, _c);
	return 3*half*half + func(_N - 1, _r-half, _c-half);
}


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, r, c;
	cin >> N >> r >> c;
	cout << func(N, r, c);

	return 0;
}