#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while (T--) {
        int N, M; cin >> N >> M;
        if (N >= 12 && M >= 4) cout << 11 * M + 4;
        else cout << -1;
        cout << "\n";
    }


    return 0;
}