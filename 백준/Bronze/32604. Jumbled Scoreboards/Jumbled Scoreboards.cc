#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    bool ans = true;
    int a, b; cin >> a >> b;
    int c, d;
    while (--N) {
        cin >> c >> d;
        if (a <= c && b <= d) {
            a = c;
            b = d;
        }
        else {
            ans = false;
        }
    }
    cout << (ans ? "yes" : "no");
    return 0;
}