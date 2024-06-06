#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, P; cin >> A >> P;
    int ans = 7 * A - 13 * P;
    if (ans > 0) cout << "Axel";
    else if (ans < 0) cout << "Petra";
    else cout << "lika";
    return 0;
}