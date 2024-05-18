#include <iostream>
#include <cmath>
using namespace std;

typedef long long ll;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    ll p1, q1, p2, q2;
    cin >> p1 >> q1 >> p2 >> q2;
    ll mom = p1 * p2;
    ll son = q1 * q2 * 2;
    if (mom % son == 0) cout << 1;
    else cout << 0;
    
    return 0;
}