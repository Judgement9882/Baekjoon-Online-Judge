#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    cout.precision(4);
    cout << fixed;
    double transform[4] = { 2.2046, 0.4536, 0.2642, 3.7854 };
    while (T--) {
        double val; string order;
        cin >> val >> order;
        if (order.compare("kg") == 0) {
            cout << val * transform[0] << " " << "lb\n";
        }
        else if (order.compare("l") == 0) {
            cout << val * transform[2] << " " << "g\n";
        }
        else if (order.compare("lb") == 0) {
            cout << val * transform[1] << " " << "kg\n";
        }
        else if (order.compare("g") == 0) {
            cout << val * transform[3] << " " << "l\n";
        }
    }
    return 0;
}