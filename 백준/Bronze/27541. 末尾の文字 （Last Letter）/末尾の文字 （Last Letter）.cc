#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    string S;
    cin >> N >> S;

    for (int i = 0; i < N; i++) {
        if (i == N - 1) {
            if (S[i] != 'G') cout << S[i] << 'G';
        }
        else cout << S[i];
    }
    
    return 0;
}