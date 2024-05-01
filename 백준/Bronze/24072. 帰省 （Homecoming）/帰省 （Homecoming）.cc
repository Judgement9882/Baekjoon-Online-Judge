#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B, C;
    cin >> A >> B >> C;
    if (A <= C && C < B) cout << 1;
    else cout << 0;
    return 0;
}