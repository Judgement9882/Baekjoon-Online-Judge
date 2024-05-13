#include <iostream>
#include <string>
using namespace std;
string alphabet[10] = {
    "0000\n0  0\n0  0\n0  0\n0000\n",
    "   1\n   1\n   1\n   1\n   1\n",
    "2222\n   2\n2222\n2\n2222\n",
    "3333\n   3\n3333\n   3\n3333\n",
    "4  4\n4  4\n4444\n   4\n   4\n",
    "5555\n5\n5555\n   5\n5555\n",
    "6666\n6\n6666\n6  6\n6666\n",
    "7777\n   7\n   7\n   7\n   7\n",
    "8888\n8  8\n8888\n8  8\n8888\n",
    "9999\n9  9\n9999\n   9\n   9\n"
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string str; cin >> str;
    for (int i = 0; i < str.length(); i++) {
        cout << alphabet[str[i] - '0'] << '\n';
    }
    return 0;
}