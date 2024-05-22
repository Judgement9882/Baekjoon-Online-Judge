#include <iostream>

using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // a : 1000KWH에 대한 KWH당 요율, 
    // b : 추가 사용량에 대한 KWH당 요율
    // n : 처리할 고객 수

    int a, b, n, energy, fee; 
    cin >> a >> b >> n;
    while (n--) {
        cin >> energy;
        fee = 0;
        if (energy > 1000) fee = 1000 * a + (energy - 1000) * b;
        else fee = energy * a;
        cout << energy << " " << fee << "\n";
    }

    return 0;
}