// https://www.acmicpc.net/problem/5928

#include <bits/stdc++.h>
using namespace std;

int D, H, M;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> D >> H >> M;

    int tm = 11 * (60 * 24 + 60 + 1);
    int tm1 = D * 60 * 24 + H * 60 + M;

    if (tm > tm1) cout << "-1";
    else cout << tm1 - tm;

    return 0;
}