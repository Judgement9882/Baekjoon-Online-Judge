#include <bits/stdc++.h>
#define MAX_N 101
using namespace std;
int arr[MAX_N];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, M; cin >> N >> M;
    for (int i = 1; i <= N; i++) arr[i] = i;
    while (M--) {
        int i, j; cin >> i >> j;
        int len = j - i + 1;
        int num = 0;
        for (int k = i; k < i + len/2; k++) {
            swap(arr[k], arr[j - num]);
            num++;
        }
    }
    for (int i = 1; i <= N; i++) cout << arr[i] << " ";
    return 0;
}