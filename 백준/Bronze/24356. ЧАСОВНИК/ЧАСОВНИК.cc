#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t1, m1, t2, m2;
    cin >> t1 >> m1 >> t2 >> m2;
    int start = t1 * 60 + m1;
    int end = t2 * 60 + m2;
    if (start > end) end += (60*24);
    int ans = end - start;
    cout << ans << " " << ans / 30;
    return 0;
}