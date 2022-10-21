/*
    https://www.acmicpc.net/problem/11727

    2N 타일링2
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[1002];
int mod_num = 10007;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    
    dp[1] = 1;
    dp[2] = 3; // 1 + 1 + 1
    // dp[3] = 5; // 1 + 2 + 2
    // dp[4] = 11; // 1 + 6 + 4
    for (int i = 3; i < N+1; i++) {
        dp[i] = dp[i - 1] + 2 * dp[i - 2];
        dp[i] %= mod_num;
    }
    cout << dp[N];

    return 0;
}
