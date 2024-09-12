#include <iostream>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int m, a, b;
	cin >> m >> a >> b;
	int ans = 0;
	while (a != b) {
		a++; ans++;
		if (a == m + 1) a = 1;
	}
	cout << ans;
	return 0;
}