#include <bits/stdc++.h>
#define MAX_N 10001
using namespace std;
long long dp[MAX_N];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i < MAX_N; i++) {
        dp[i] = dp[i - 1] + i;
    }

    int N; cin >> N;
    long long ans = 0;
    for (int i = 1; i <= N; i++) {
        ans += dp[i]; // 정방향
    }
    for (int i = N - 1; i > 0; i -= 2) {
        ans += dp[i]; // 역방향
    }

    cout << ans;
    return 0;
}