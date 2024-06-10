#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int ten = 10, ans = 0, num = 0, out, in;
    while (ten--) {
        cin >> out >> in;
        num += in - out;
        ans = max(ans, num);
    }
    cout << ans;
    return 0;
}