#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.precision(6);
    cout << fixed;
    double A, B, C; cin >> A >> B >> C;
    A *= 0.229 * 0.324 * 2;
    B *= 0.297 * 0.42 * 2;
    C *= 0.21 * 0.297;
    cout << A + B + C;
    return 0;
}