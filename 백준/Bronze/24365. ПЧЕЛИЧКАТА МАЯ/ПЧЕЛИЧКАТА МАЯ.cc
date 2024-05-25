#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    int mean = (a + b + c) / 3;
    cout << (mean - a) * 2 + (mean - b);
    
    return 0;
}