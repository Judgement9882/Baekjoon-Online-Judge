#include <bits/stdc++.h>
#define MAX_N 1001
#define MOD 10007
using namespace std;
long long dp[MAX_N][10];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 10; i++) {
        dp[1][i] = 1;
    }

    int N; cin >> N;
    for (int i = 2; i <= N; i++) {
        dp[i][0] = 1;
        for (int j = 1; j < 10; j++) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] % MOD;
        }
    }

    long long ans = 0;
    for (int i = 0; i < 10; i++) {
        ans += dp[N][i] % MOD;
    }
    cout << ans % MOD;
    return 0;
}