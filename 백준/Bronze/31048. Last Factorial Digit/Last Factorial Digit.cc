#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    while (N--) {
        int num; cin >> num;
        int ans = 1;
        for (int i = 2; i <= num; i++) { 
            ans *= i;
            if (ans >= 10) ans %= 10;
        }
        cout << ans << "\n";
    }
    return 0;
}