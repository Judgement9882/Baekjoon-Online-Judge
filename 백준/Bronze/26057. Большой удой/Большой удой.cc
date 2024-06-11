#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int L, T;
    cin >> L >> T;
    cout << abs(L - T - T);
    return 0;
}