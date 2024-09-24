#include <bits/stdc++.h>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int T; cin >> T;
	while (T--) {
		int ans = 0;
		string a, b; cin >> a >> b;
		int len = a.length();
		for (int i = 0; i < len; i++) {
			if (a[i] != b[i]) ans++;
		}
		cout << "Hamming distance is " << ans << ".\n";
	}
	return 0;
}