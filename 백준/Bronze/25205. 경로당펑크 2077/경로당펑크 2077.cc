#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N; cin >> N;
    string temp; cin >> temp;
    
    char noun[12] = { 'y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm' };
    bool flag = 1;
    for (char e : noun) {
        if (temp[N - 1] == e){ // 마지막 글자가 모음이면 break
            flag = 0;
            break;
        }
    }
    cout << flag;
    return 0;
}