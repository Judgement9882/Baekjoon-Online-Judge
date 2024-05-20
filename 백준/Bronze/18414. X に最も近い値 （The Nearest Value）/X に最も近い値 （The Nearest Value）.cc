#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int X, L, R;
    cin >> X >> L >> R;
    int ans = 0x7f7f7f7f;
    int minusAbs = 0x7f7f7f7f;
    for (int i = L; i <= R; i++) {
        if (minusAbs >= abs(X - i)) {
            ans = i;
            minusAbs = abs(X - i);
        }
    }
    cout << ans;
    
    return 0;
}