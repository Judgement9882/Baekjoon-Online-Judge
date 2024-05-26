#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, a, b, c; cin >> N;
    while (N--) {
        cin >> a >> b >> c;
        cout << a << " " << b << " " << c << "\n";
        int ans = 0;
        if (a >= 10) ans++;
        if (b >= 10) ans++;
        if (c >= 10) ans++;
        switch (ans) {
        case 0:
            cout << "zilch\n\n";
            break;
        case 1:
            cout << "double\n\n";
            break;
        case 2:
            cout << "double-double\n\n";
            break;
        case 3:
            cout << "triple-double\n\n";
            break;
        }
    }
    
    return 0;
}