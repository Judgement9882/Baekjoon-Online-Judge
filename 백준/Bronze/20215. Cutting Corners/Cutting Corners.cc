#include <iostream>
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    double w, h; cin >> w >> h;
    double len = sqrt(w * w + h * h);
    cout.precision(6);
    cout << fixed;
    cout << abs(w + h - len);
    return 0;
}