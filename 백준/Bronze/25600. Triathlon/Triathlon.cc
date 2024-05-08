#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    int ans = 0;
    int a, d, g;
    while (N--) {
        cin >> a >> d >> g;
        int temp = a * (d + g);
        ans = max(ans, a == d + g ? 2 * temp : temp);
    }
    cout << ans;
    return 0;
}