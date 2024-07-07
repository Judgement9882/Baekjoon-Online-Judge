#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;
    while (n--) {
        cout << "Denominations: ";
        int d; cin >> d;
        bool ans = true;
        int prev = 0;
        while (d--) {
            int num; cin >> num; cout << num << " ";
            if (prev * 2 <= num) prev = num;
            else ans = false;
        }
        cout << "\n";
        if (ans) cout << "Good coin denominations!\n\n";
        else cout << "Bad coin denominations!\n\n";
    }
    
    return 0;
}