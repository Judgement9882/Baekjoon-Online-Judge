#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    long long N; cin >> N;
    int ans = 0;
    while (N != 1) {
        if (N % 2 == 1) {
            N = N * 3 + 1;
            ans++;
        }
        else {
            while (N > 1 && N % 2 == 0) {
                ans++;
                N /= 2;
            }
        }
        
    }
    cout << ans;
    return 0;
}