#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    int A = 0, B = 0;
    while (N--) {
        int a1, b1;
        cin >> a1 >> b1;
        if (a1 > b1) {
            A += a1 + b1;
        }
        else if (a1 < b1) {
            B += a1 + b1;
        }
        else {
            A += a1;
            B += b1;
        }
    }
    cout << A << " " << B;
    return 0;
}