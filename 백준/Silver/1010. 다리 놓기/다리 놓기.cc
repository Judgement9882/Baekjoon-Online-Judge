/*
    https://www.acmicpc.net/problem/20058

    다리 놓기
*/

#include <iostream>
using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);

    int T; cin >> T;
    while (T--) {
        int N, M; cin >> N >> M;
        long long num = 1;

        // 절반보다 크면 뺌
        if (N > (M / 2)) {
            N = M - N;
        }

        for (int i = M; i > M - N; i--) {
            num *= i;
        }
        
        for (int i = N; i > 0; i--) {
            num /= i;
        }
        cout << num << "\n";
    }

    return 0;
}
