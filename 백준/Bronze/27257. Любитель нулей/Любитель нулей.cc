#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    while (N % 10 == 0) {
        N /= 10;
    }

    int cnt = 0;
    while (N) {
        if (N % 10 == 0) cnt++;
        N /= 10;
    }
    cout << cnt;
    return 0;
}