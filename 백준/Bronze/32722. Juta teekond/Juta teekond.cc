#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a, b, c;
    cin >> a >> b >> c;
    bool ans = true;
    if (!(a == 1 || a == 3)) ans = false;
    if (!(b == 6 || b == 8)) ans = false;
    if (!(c == 2 || c == 5)) ans = false;
    cout << (ans ? ("JAH") : ("EI"));
    return 0;
}