/*
	https://www.acmicpc.net/problem/2747

	n번째 피보나치수 구하기
*/

#include <iostream>

using namespace std;

int dp[47];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	dp[1] = 1;
	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	cout << dp[n];
	return 0;
}