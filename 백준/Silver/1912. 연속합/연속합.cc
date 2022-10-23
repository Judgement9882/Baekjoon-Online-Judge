/*
    https://www.acmicpc.net/problem/1912

    연속합
*/

#include <iostream>
#include <algorithm>
using namespace std;

int dp[100002];
int arr[100002];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    
    
    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
        dp[i] = arr[i];
    }
    
    for (int i = 1; i <= N; i++) {
        // 누적합이므로 이전 1부터 N까지 값들을 비교해가면서 갱신
        dp[i] = max(dp[i], dp[i - 1] + arr[i]);
    }
    cout << *max_element(dp + 1, dp + N + 1);

    return 0;
}
