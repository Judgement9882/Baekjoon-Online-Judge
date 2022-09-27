/*
    https://www.acmicpc.net/problem/15657

    N 과 M 8
*/


#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int arr[10];
int show_arr[10];

void func(int k) {
    
    if (M == k) {
        for (int i = 0; i < M; i++) {
            cout << show_arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; i++) {
        // 비내림차순 검사
        if (k > 0) {
            if (show_arr[k - 1] > arr[i]) continue;
        }
        
        show_arr[k] = arr[i];
        func(k + 1);
    }


}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + N);
    func(0);
    

    return 0;
}
