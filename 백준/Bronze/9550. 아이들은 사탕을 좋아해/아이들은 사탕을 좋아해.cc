/*
	https://www.acmicpc.net/problem/9550

	사탕
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, N, K, cnt, candy;
	cin >> T;
	while (T--) {
		cnt = 0;
		cin >> N >> K;
		
		while (N--) {
			cin >> candy;
			cnt += candy / K;
		}

		cout << cnt << "\n";
	}
	
	return 0;
}