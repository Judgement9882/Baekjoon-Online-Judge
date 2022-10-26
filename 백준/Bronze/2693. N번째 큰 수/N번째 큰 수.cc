/*
    https://www.acmicpc.net/problem/2693

    N번째 큰 수
*/

#include <iostream>
#include <algorithm>
using namespace std;


int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);

    int T; cin >> T;
    while (T--) {
        int A[10];
        for (int i = 0; i < 10; i++) {
            cin >> A[i];
        }
        sort(A, A + 10, greater<>());
        cout << A[2] << "\n";
    }


    return 0;
}
