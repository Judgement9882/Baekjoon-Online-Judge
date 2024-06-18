#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, A; cin >> n >> A;
    int ans = 0;
    while (n--) {
        int temp; cin >> temp;
        ans += temp / A;
    }
    cout << ans;
    
    return 0;
}