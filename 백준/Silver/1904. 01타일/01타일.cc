#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

long long dp[1000002];

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= N; i++) {
        dp[i] = ((dp[i - 1] % 15746) + (dp[i - 2] % 15746)) % 15746;
    }
    cout << dp[N];

    return 0;
}