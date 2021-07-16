#include <iostream>

using namespace std;

int main() {

    // I/O speed management
    cin.tie(0);
    ios_base::sync_with_stdio(0);

    int N, K; // N : kind of coin, K : Value
    cin >> N >> K;

    int value[10];

    for (int i = 0; i < N; i++) {
        int v;
        cin >> v;
        value[i] = v;
    }

    int sum = 0;

    for (int i = N - 1; i >= 0; i--) {
        int mok = K / value[i];
        sum += mok;
        K -= value[i] * mok;
        if (K == 0) {
            break;
        }
    }

    cout << sum;


    return 0;
}