#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    double price[5] = { 350.34, 230.90, 190.55, 125.30, 180.90 };
    cout << fixed;
    cout.precision(2);
    while (N--) {
        double ans = 0.0;
        int five = 5;
        for (int i = 0; i < five; i++) {
            int num; cin >> num;
            ans += num * price[i];
        }
        cout << "$" << ans << "\n";
    }
    return 0;
}