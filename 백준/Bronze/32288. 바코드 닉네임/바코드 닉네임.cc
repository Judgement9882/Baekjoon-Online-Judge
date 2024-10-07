#include <bits/stdc++.h>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    string str; cin >> str;
    for (int i = 0; i < N; i++) {
        if (str[i] == 'l') cout << "L";
        else cout << "i";
    }
    return 0;
}