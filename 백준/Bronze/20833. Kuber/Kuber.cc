#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    long ans = 0;
    for (int i = 1; i <= n; i++) {
        ans += i * i * i;
    }
    cout << ans;
    return 0;
}