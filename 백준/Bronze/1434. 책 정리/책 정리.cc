#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;

int A[52];
int B[52];

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, M; cin >> N >> M;
    
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    for (int i = 0; i < M; i++) {
        cin >> B[i];
    }

    int A_index = 0;
    int B_index = 0;
    
    while (A_index != N && B_index != M) {
        // 책을 넣을 수 있는 경우
        if (A[A_index] >= B[B_index]) {
            A[A_index] -= B[B_index++];
        }

        // 없는 경우
        else A_index++;
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
        ans += A[i];
    }
    cout << ans;
    return 0;
}