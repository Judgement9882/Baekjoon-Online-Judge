#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, c, p;
    cin >> n;
    while (n--) {
        cin >> c >> p;
        cout << c << " " << p << "\n";
        cout << c * p - 2 * (c - 1) << "\n";
    }


    return 0;
}