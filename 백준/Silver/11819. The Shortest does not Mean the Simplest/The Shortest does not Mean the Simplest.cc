#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using lll = __int128;

ll rec_mod(lll a, lll b, lll c) {
	ll ret = 1;
	for (; b; b /= 2) {
		if (b % 2 == 1) ret = ret * a % c;
		a = a * a % c;
	}
	return ret;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	ll a, b,  c;
	cin >> a >> b >> c;
	cout << rec_mod(a, b, c);
	return 0;
}