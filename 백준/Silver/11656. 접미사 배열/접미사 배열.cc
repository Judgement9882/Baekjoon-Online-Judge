/*
    https://www.acmicpc.net/problem/11656

    접미사배열
*/


#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string name[1002];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string temp; cin >> temp;
    name[0] = temp;
    int leng = name[0].length();
    for (int i = 1; i < leng; i++) {
        reverse(temp.begin(), temp.end());
        temp.pop_back();
        reverse(temp.begin(), temp.end());
        name[i] = temp;
    }

    sort(name, name + leng);
    for (int i = 0; i < leng; i++) {
        cout << name[i] << "\n";
    }
    return 0;
}
