/*
    https://www.acmicpc.net/problem/2193

    이친수
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long dp[92];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    
    dp[1] = 1; // 1
    dp[2] = 1; // 10 
    //dp[3] = 2; // 101, 100
    //dp[4] = 3; // 1000, 1001, 1010
    //dp[5] = 5; // 10 000, 001, 010, 100, 101
    //dp[6] = 8; // 10 0000, 0001, 0010, 0100, 0101, 1000, 1001, 1010
    //dp[7] = 13; // 10 00000, 00001, 00010, 00100, 00101, 01000, 01001, 01010, 10000, 10001, 10010, 10100, 10101

    for (int i = 3; i <= N; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    cout << dp[N];

    return 0;
}
