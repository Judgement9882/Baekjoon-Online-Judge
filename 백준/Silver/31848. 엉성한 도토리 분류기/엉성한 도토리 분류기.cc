#include <iostream>
using namespace std;
int a[200004];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N, num, Q; 
    cin >> N;
    
    int temp = 0;
    for (int i = 1; i <= N; i++) {
        cin >> num;
        num += i - 1; // 구멍을 지날 때 마다 -1
        if (temp < num) {
            temp = num;
            while (num > 0 && !a[num]) {
                a[num--] = i;
            }
        }
    }
    
    cin >> Q;

    while (Q--) {
        cin >> num;
        cout << a[num] << " ";
    }

    return 0;
}