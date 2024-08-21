#include <iostream>
using namespace std;
int dp[1001];
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	for (int i = 1; i <= 1000; i++) {
		dp[i] = 3 * i * (i + 1) / 2;
	}
	int N; cin >> N;
	int ans = 0;
	for (int i = 1; i <= N; i++) ans += dp[i];
	cout << ans;
	return 0;
}