#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string str; cin >> str;
    int A = 0, B = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str[i] == 'A') A++;
        else B++;
    }
    cout << A << " : " << B;
    return 0;
}