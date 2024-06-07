#include <iostream>
#include <cmath>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    cout.precision(1);
    cout << fixed;
    while (N--) {
        double A, B; cin >> A >> B;
        cout << abs(A - B) << "\n";
    }
    return 0;
}