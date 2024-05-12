#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n; cin >> n;
    while (n--) {
        int a, b, fold;
        cin >> a >> b >> fold;
        cout << "Data set: " << a << " " << b << " " << fold << '\n';
        while (fold--) {
            if (a > b) a /= 2;
            else b /= 2;
        }
        cout << max(a, b) << " " << min(a, b);
        cout << "\n";
        cout << "\n";
    }
    return 0;
}