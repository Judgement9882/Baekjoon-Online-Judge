// https://www.acmicpc.net/problem/16486

#include <bits/stdc++.h>

using namespace std;

double d1, d2;

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> d1 >> d2;

    cout << fixed;
    cout.precision(6);
    cout << 2 * (d1 + d2 * 3.141592);

    return 0;
}