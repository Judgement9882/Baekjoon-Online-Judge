#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int num = 0;
    cin >> num;
    
    int A, B, C;
    cin >> A >> B >> C;
    
    int ans = 0;
    if (A >= num) ans += num;
    else ans += A ;
    if (B >= num) ans += num;
    else ans += B;
    if (C >= num) ans += num;
    else ans += C;

    cout << ans;
    return 0;
}