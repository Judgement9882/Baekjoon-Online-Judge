#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.precision(2);
    cout << fixed;
    double X, Y; int N;
    cin >> X >> Y >> N;
    double ans = 1000 * X / Y;
    while (N--) {
        double x, y; cin >> x >> y;
        ans = min(ans, 1000 * x / y);
    }
    cout << ans;
    return 0;
}