#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.precision(2);
    cout << fixed;

    double k; cin >> k;
    double fee = 25 + k / 100;
    if (fee < 100) fee = 100;
    else if (fee > 2000) fee = 2000;
    cout << fee;
    return 0;
}