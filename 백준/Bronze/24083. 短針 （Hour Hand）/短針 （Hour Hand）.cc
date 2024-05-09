#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B; cin >> A >> B;
    cout << ((A+B)%12==0?12: (A + B) % 12);
    return 0;
}