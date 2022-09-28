/*
    https://www.acmicpc.net/problem/15664

    N 과 M 10
*/


#include <iostream>
#include <algorithm>

using namespace std;

int N, M;

int show_arr[10];
int arr[10];
bool isused[10];

void func(int k) {
    
    if (M == k) {
        for (int i = 0; i < M; i++) {
            cout << show_arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    int temp = 0;
    for (int i = 0; i < N; i++) {
        if (!isused[i] && temp != arr[i]) {
            if (k > 0) {
                if (show_arr[k - 1] > arr[i]) continue;
            }
            isused[i] = 1;
            show_arr[k] = arr[i];
            temp = show_arr[k];
            func(k + 1);
            isused[i] = 0;
        }   
    }
}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M;
    
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    
    sort(arr, arr+N);
    func(0);
    

    return 0;
}
