// https://www.acmicpc.net/problem/17388

#include <bits/stdc++.h>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int S, K, H;
	cin >> S >> K >> H;
	if (S + K + H >= 100) {
		cout << "OK";
		return 0;
	}

	int mn = min(S, min(K, H));
	if (mn == S) cout << "Soongsil";
	else if (mn == K) cout << "Korea";
	else cout << "Hanyang";

	return 0;
}