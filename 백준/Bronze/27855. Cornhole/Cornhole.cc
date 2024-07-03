#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int H1, B1, H2, B2;
    cin >> H1 >> B1 >> H2 >> B2;
    int a = H1 * 3 + B1, b = H2 * 3 + B2;
    if (a > b) cout << 1 << " " << a - b;
    else if (a < b) cout << 2 << " " << b - a;
    else cout << "NO SCORE";
    return 0;
}