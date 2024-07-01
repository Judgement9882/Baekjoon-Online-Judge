#include <iostream>
using namespace std;
int a[11], b[11];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    while (true) {
        fill(a, a + 11, 0);
        fill(b, b + 11, 0);
        string A, B; cin >> A >> B;
        if (A == "0" && B == "0") break;
        for (int i = 0; i < A.length(); i++) {
            a[i] = A[A.length() - i - 1] - '0';
        }
        
        for (int i = 0; i < B.length(); i++) {
            b[i] = B[B.length() - i - 1] - '0';
        }

        int num = 0, index = 0, ans = 0;
        while (index < 11) {
            if (num + a[index] + b[index] >= 10) {
                num = 1;
                ans++;
            }
            else num = 0;
            index++;
        }
        cout << ans << "\n";
    }
    return 0;
}