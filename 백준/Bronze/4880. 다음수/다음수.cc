#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a1, a2, a3; 
    while (true) {
        cin >> a1 >> a2 >> a3;
        if (a1 == 0 && a2 == 0 && a3 == 0) break;
        if (a3 - a2 == a2 - a1) cout << "AP " << a3 + (a3 - a2) << "\n";
        else cout << "GP " << a3 * (a3 / a2) << "\n";
    }
    return 0;
}