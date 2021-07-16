#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int rec_mod(ll a, ll b, ll c) {
	if (b == 1) return a % c; // base condition

	ll val = rec_mod(a, b / 2, c);
	val = val * val % c;

	if (b % 2 == 0) { // 2k
		return val;
	}
	else { // 2k + 1
		return val * a % c;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	ll a, b,  c;
	cin >> a >> b >> c;
	cout << rec_mod(a, b, c);
	return 0;
}