#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while (T--) {
        int E, N, num; cin >> E >> N;
        int ans = 0;
        while (N--) {
            cin >> num;
            if (E < num) ans++;
        }
        cout << ans << "\n";
    }
    return 0;
}