#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
string group[35];
unordered_map<string, int> map;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    map.insert({ "000", 0 });
    map.insert({ "001", 1 });
    map.insert({ "010", 2 });
    map.insert({ "011", 3 });
    map.insert({ "100", 4 });
    map.insert({ "101", 5 });
    map.insert({ "110", 6 });
    map.insert({ "111", 7 });

    string str; cin >> str;
    if (str.length() % 3 != 0) {
        if (str.length() % 3 == 1) str = "00" + str;
        else str = "0" + str;
    }
    int len = str.length();
    for (int i = 0; i < len; i+=3) {
        cout << map[(str.substr(i, 3))];
    }

    return 0;
}