#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int num = 0;
    while (!cin.eof()) {
        string temp;
        getline(cin, temp);
        num++;
    }
    cout << num-1;

    return 0;
}