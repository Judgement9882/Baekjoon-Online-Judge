#include <iostream>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int k; cin >> k;
    cin.ignore();
    string str; getline(cin, str);
    int len = str.length();
    for (int i = 0; i < len; i++) {
        if (str[i] >= 'a' && str[i] <= 'z') {
            int temp = str[i] - 'a';
            temp = (temp - k + 26) % 26;
            str[i] = temp + 'a';
            k = (k % 25) + 1;
        }
    }
    cout << str;
    return 0;
}