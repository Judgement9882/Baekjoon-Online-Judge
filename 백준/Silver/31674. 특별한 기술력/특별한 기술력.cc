#include <iostream>
#include <algorithm>

#define MAX_N 200001

using namespace std;

int N;
long long H[MAX_N];
long long MOD = 1e9+7;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N;
    for(int i = 0; i < N; i++) cin >> H[i];
    sort(H, H+N);
    long long ans = 0;
    long long multiply = 1;
    for(int i = 0; i < N; i++){
        ans += (H[i] % MOD) * (multiply % MOD) % MOD;
        ans %= MOD;
        multiply *= 2;
        multiply %= MOD;
    }
    cout << ans % MOD;
    return 0;
}