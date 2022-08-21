/*
	https://www.acmicpc.net/problem/2547

	사탕선생
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		long long cnt = 0;
		for (int i = 0; i < N; i++) {
			long long candy; cin >> candy;
			cnt += candy;
			cnt %= N;
		}
		if (cnt % N == 0) cout << "YES\n";
		else cout << "NO\n";
	}
	
	
	return 0;
}