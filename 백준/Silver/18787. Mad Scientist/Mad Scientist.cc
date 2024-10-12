#include <bits/stdc++.h>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    string A, B; cin >> A >> B;
    int ans = 0;
    bool flag = false;
    for (int i = 0; i < N; i++) {
        if (A[i] != B[i]) flag = true;
        if (flag && A[i] == B[i]) {
            flag = false;
            ans++;
        }
    
    }
    cout << ans;
    return 0;
}