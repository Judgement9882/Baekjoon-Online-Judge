/*
    https://www.acmicpc.net/problem/10409

    서버
*/


#include <iostream>
using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n, T; cin >> n >> T;
    int num = 0;
    while (n--) {
        int temp; cin >> temp;
        T -= temp;
        if (T >= 0) num++;
        else break;
    }
    cout << num;
    return 0;
}
