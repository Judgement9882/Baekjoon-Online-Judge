#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N; cin >> N;
    int div = N / 5;
    int mod = N % 5;
    for (int i = 0; i < div; i++) {
        cout << "V";
    }
    for (int i = 0; i < mod; i++) {
        cout << "I";
    }

    return 0;
}