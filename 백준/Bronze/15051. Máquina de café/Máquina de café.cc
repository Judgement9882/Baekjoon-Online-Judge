#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int a, b, c; cin >> a >> b >> c;

    cout << min(min(2 * (a + c), 2 * b + 4 * c), 2 * b + 4 * a);
    

    return 0;
}