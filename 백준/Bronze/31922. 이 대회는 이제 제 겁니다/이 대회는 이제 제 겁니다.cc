#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int A, P, C;
    cin >> A >> P >> C;
    cout << max(A + C, P);
    
    return 0;
}