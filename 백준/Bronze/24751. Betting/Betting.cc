#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    double a; cin >> a;
    cout.precision(10);
    cout << fixed;
    double b = 100.0 - a;
    cout << 100.0 / a << "\n" << 100.0 / b;
    return 0;
}