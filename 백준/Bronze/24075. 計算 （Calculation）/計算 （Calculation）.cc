#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B;
    cin >> A >> B;
    cout << max(A + B, A - B) << "\n" << min(A + B, A - B);
    return 0;
}