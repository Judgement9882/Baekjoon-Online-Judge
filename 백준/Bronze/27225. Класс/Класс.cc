#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int A, B;
    cin >> A >> B;
    int ans = 0;
    if ((A + B) % 2 == 1) ans++;
    ans += 2*min(A, B);
    cout << ans;
    return 0;
}