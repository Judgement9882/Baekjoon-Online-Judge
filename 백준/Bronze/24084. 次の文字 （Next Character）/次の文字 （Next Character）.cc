#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; string S;
    cin >> N >> S;
    for (int i = 0; i < N - 1; i++) {
        if (S[i + 1] == 'J') cout << S[i] << "\n";
    }
    return 0;
}