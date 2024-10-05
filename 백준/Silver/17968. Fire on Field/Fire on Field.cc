#include <bits/stdc++.h>
#define MAX_N 1001
using namespace std;
int dp[MAX_N];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	dp[0] = 1;
	dp[1] = 1;
	int N; cin >> N;
	for (int i = 2; i <= N; i++) {
		int num = 1;
		while (true) {
			dp[i] = num;

			int k = 1;
			bool flag = false;
			while (true) {
				if (i - 2 * k < 0) {
					flag = true;
					break;
				}
				if (dp[i] - dp[i - k] == dp[i - k] - dp[i - 2 * k]) break;
				k++;
			}

			if (flag) break;
			else num++;
		}
		
	}

	cout << dp[N];

	return 0;
}