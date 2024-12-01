#include <bits/stdc++.h>
using namespace std;
int ans[3];
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int n, a, b;
    cin >> n >> a >> b;
    for(int i = 1; i <= n; i++){
        if(i % a == 0){
            if(i % b == 0) ans[2]++;
            else ans[0]++;
        }else if(i % b == 0) ans[1]++;
    }
    for(auto k : ans) cout << k << " " ;
    return 0;
}