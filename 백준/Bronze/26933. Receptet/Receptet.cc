#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int num = 0;
    cin >> num;
    int ans = 0;
    while (num--) {

        int A, B, C; cin >> A >> B >> C;
        if (A >= B) continue;
        ans += (B - A) * C;


    }
    cout << ans;
    return 0;
}