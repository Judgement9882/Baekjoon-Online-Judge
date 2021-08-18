// https://www.acmicpc.net/problem/17362

#include <bits/stdc++.h>
using namespace std;

int N;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;

    if (N % 8 == 1) cout << "1";
    else if (N % 8 == 2 || N % 8 == 0) cout << "2";
    else if (N % 8 == 3 || N % 8 == 7) cout << "3";
    else if (N % 8 == 4 || N % 8 == 6) cout << "4";
    else cout << "5";

    return 0;
}