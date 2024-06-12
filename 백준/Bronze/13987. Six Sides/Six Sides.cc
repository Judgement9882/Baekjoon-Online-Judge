#include <iostream>
using namespace std;
int A[6], B[6];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.precision(5);
    cout << fixed;
    for (int i = 0; i < 6; i++) cin >> A[i];
    for (int i = 0; i < 6; i++) cin >> B[i];
    double win = 0, lose = 0;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            if (A[i] > B[j]) win++;
            else if (A[i] < B[j]) lose++;
        }
    }
    cout << win / (win+lose);
    
    return 0;
}