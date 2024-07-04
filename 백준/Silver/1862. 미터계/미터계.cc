#include <iostream>
using namespace std;

int power(int a, int b) {
    int ret = 1;
    for (int i = 0; i < b; i++) ret *= a;
    return ret;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    int mul = 0, ans = 0;
    while (N) {
        int num = N % 10;
        if (num > 4) ans += (num - 1) * power(9, mul);
        else ans += num * power(9, mul);
        mul++;
        N /= 10;
    }
    cout << ans;
    return 0;
}