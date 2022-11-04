#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    // 1 -> (2+1)^2
    // 2 -> (3+2)^2
    // 3 -> (5+4)^2
    // 4 -> (9+8)^2
    // 5 -> (17+16)33^2
    int dp[16] = { 0, };

    dp[1] = 3;
    for (int i = 2; i < 16; i++) {
        dp[i] = dp[i - 1] * 2 - 1;
        //cout << i << " " << dp[i] << "\n";
    }
    cout << dp[N] * dp[N];
    

    return 0;
}