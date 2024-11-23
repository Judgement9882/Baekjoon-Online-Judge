#include <bits/stdc++.h>
using namespace std;
int score[6] = { 13, 7, 5, 3, 3, 2 };
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int six = 6;
    double a = 0, b = 0;
    for (int i = 0; i < six; i++) {
        int num; cin >> num;
        a += num * score[i];
    }
    for (int i = 0; i < six; i++) {
        int num; cin >> num;
        b += num * score[i];
    }
    b += 1.5;
    if (a > b) cout << "cocjr0208";
    else cout << "ekwoo";
    return 0;
}