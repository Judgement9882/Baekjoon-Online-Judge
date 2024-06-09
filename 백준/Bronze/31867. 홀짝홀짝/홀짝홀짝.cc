#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    string temp; cin >> temp;
    int odd = 0, even = 0;
    for (int i = 0; i < N; i++) {
        if ((temp[i] - '0') % 2 == 0) even++;
        else odd++;
    }
    if (odd > even) cout << 1;
    else if (odd < even) cout << 0;
    else cout << -1;
    return 0;
}