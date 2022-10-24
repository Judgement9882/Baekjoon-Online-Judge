/*
    https://www.acmicpc.net/problem/11055

    가장 긴 증가 부분 수열
*/

#include <iostream>
#include <algorithm>
using namespace std;

int dp[1002];
int arr[1002];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    
    
    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
        dp[i] = 1;
    }
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= i; j++) {

            // i를 기준으로 앞인 j 범위를 탐색
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }
    cout << *max_element(dp + 1, dp + N + 1);

    return 0;
}
