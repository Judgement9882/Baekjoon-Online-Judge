// https://www.acmicpc.net/problem/19602

#include <bits/stdc++.h>
using namespace std;

int S, M, L;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> S >> M >> L;

    if (1 * S + 2 * M + 3 * L >= 10) cout << "happy";
    else cout << "sad";

    return 0;
}