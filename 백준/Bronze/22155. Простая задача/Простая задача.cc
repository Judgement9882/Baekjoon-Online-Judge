#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, i, f;
    cin >> n;
    while (n--) {
        cin >> i >> f;
        if ((i <= 1 && f <= 2) || (i <= 2 && f <= 1)) cout << "Yes\n";
        else cout << "No\n";
    }

    return 0;
}