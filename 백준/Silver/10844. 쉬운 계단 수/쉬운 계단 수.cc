/*
	https://www.acmicpc.net/problem/10844

	쉬운 계단 수
*/

#include <iostream>

using namespace std;

int mod = 1000000000;
int dp[102][10]; // 자릿수와 숫자

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);


	int N; cin >> N;
	for (int i = 1; i <= 9; i++) dp[1][i] = 1;

	// N 자리 수
	for (int i = 2; i <= N; i++) {

		// 들어올 수 있는 수는 0~9인데 0과 9는 한번씩 들어오므로 예외처리를 해줘야함.
		for (int j = 0; j <= 9; j++) {
			// 0이 아닐 경우 왼쪽 수(j-1) 에서 더함
			if (j != 0) dp[i][j] += dp[i - 1][j - 1];
			
			// 9가 아닐 경우 오른쪽 수에서 더함
			if (j != 9) dp[i][j] += dp[i - 1][j + 1];

			dp[i][j] %= mod;
		}
	}
	
	long long ans = 0;
	for (int i = 0; i <= 9; i++) {
		ans += dp[N][i];
		
	}
	cout << ans % mod;
	return 0;
}