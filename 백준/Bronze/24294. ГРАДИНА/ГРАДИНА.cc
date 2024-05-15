#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int w1, h1, w2, h2;
    cin >> w1 >> h1 >> w2 >> h2;
    cout << 2 * (h1 + h2) + 2 * max(w1, w2) + 4;

    return 0;
}