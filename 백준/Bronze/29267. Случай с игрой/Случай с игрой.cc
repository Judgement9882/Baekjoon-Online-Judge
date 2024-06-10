#include <iostream>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, k; cin >> n >> k;
    int save = 0;
    int cur = 0;
    while (n--) {
        string order;
        cin >> order;
        if (order.compare("save") == 0) {
            save = cur;
        }
        if (order.compare("load") == 0) {
            cur = save;
        }
        if (order.compare("shoot") == 0) {
            cur--;
        }
        if (order.compare("ammo") == 0) {
            cur += k;
        }
        cout << cur << "\n";
    }
    return 0;
}