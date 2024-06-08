#include <iostream>
using namespace std;
bool l, k, p;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int three = 3;
    while (three--) {
        string temp; cin >> temp;
        if (temp[0] == 'l') l = true;
        if (temp[0] == 'k') k = true;
        if (temp[0] == 'p') p = true;
    }
    bool ans = l && k && p;
    cout << (ans ? "GLOBAL" : "PONIX");
    return 0;
}