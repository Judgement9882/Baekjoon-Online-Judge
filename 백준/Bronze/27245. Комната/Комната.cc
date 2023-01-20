#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int A, B, C; cin >> A >> B >> C;
    if (C * 2 > min(A, B)) {
        cout << "bad";
    }
    else {
        cout << "good";
    }

    return 0;
}