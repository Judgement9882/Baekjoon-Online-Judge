#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
using ll = long long;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N; cin >> N;
    vector<int> home(N);

    for (int i = 0; i < N; i++) cin >> home[i];
    sort(home.begin(), home.end());

    if (N & 1) cout << home[N / 2];
    else {
        ll ans = 0, ans_idx = 0;
        int two = 2;
        while (two--) {
            ll temp = 0;
            int select = N / 2 - two;
            for (int i = 0; i < N; i++) {
                if (i == select) continue;
                temp += abs(home[select] - home[i]);
            }

            if (ans < temp) {
                ans = temp;
                ans_idx = home[select];
            }
        }
        cout << ans_idx;
    }
    return 0;
}