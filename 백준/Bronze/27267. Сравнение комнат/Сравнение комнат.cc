#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int A, B, C, D; cin >> A >> B >> C >> D;
    if (A * B > C * D) {
        cout << "M";
    }
    else if (A * B == C * D) {
        cout << "E";
    }
    else {
        cout << "P";
    }


    return 0;
}