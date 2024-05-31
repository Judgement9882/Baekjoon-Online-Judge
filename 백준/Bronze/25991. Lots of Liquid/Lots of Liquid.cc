#include <iostream>
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;
    cout.precision(6);
    cout << fixed;

    double sum = 0, temp;
    while (n--) {
        cin >> temp;
        sum += temp * temp * temp;
    }
    cout << cbrt(sum);
    
    
    return 0;
}