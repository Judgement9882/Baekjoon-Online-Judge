/*
    https://www.acmicpc.net/problem/7795

    먹을것인가 먹힐것인가
*/


#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

long long A[20002];
long long B[20002];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int T; cin >> T;
    while (T--) {
        int A_num, B_num; cin >> A_num >> B_num;
        for (int i = 0; i < A_num; i++) {
            cin >> A[i];
        }
        sort(A, A + A_num);
        
        for (int i = 0; i < B_num; i++) {
            cin >> B[i];
        }
        sort(B, B + B_num);

        int i = 0, j = 0, sum = 0, cnt = 0;
        while (1) {

            // 끝에 도달하면 끝
            if (i == A_num) {
                break;
            }

            // j가 먼저 도달하면 남은 i는 모두 cnt 만큼의 수와 매칭됨
            if (j == B_num) {
                sum += cnt;
                i++;
                continue;
            }

            // match
            if (A[i] > B[j]) {
                cnt++;
                j++;
            }
            else {
                i++;
                sum += cnt;
            }
            
        }

        cout << sum << "\n";
    }

    // 1 1 3 7 8
    // 1 3 6
    return 0;
}
