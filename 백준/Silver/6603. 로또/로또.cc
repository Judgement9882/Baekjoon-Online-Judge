/*
    https://www.acmicpc.net/problem/6603

    로또
*/


#include <iostream>
#include <algorithm>

using namespace std;

int k;
int arr[14];
int lotto[14];
bool isused[14];

void func(int K) {

    if (K == 6) {
        for (int i = 0; i < K; i++) {
            cout << lotto[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < k; i++) {
        if (!isused[i]) {
            if (K > 0) {
                if (lotto[K - 1] > arr[i]) continue;
            }
            isused[i] = 1;
            lotto[K] = arr[i];
            func(K + 1);
            isused[i] = 0;
        }
    }


}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    while (1) {
        cin >> k;
        if (k == 0) break;
        for (int i = 0; i < k; i++) {
            cin >> arr[i];
        }

        func(0);
        cout << "\n";
    }

    

    return 0;
}
