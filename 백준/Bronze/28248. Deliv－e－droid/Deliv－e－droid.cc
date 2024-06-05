#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int P, C; cin >> P >> C;
    cout << P * 50 - C * 10 + (P > C ? 500 : 0);
    return 0;
}