#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int S, A, B;
    cin >> S >> A >> B;
    int ans = 250;
    while (S > A) {
        A += B;
        ans += 100;        
    }
    cout << ans;
    return 0;
}