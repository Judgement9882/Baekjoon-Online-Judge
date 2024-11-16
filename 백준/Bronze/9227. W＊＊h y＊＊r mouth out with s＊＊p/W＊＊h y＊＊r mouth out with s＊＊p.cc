#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string str;
    vector<pair<char, char>> arr;
    while (true) {
        cin >> str;
        if (str == "##") break;
        arr.push_back({ str[0], str[1] });
    }
    cin.ignore();
    while (true) {
        getline(cin, str);
        if (str == "#") break;
        int len = str.length();
        for (int i = 0; i < len - 3; i++) {
            int arr_len = arr.size();
            for (int j = 0; j < arr_len; j++) {
                if (str[i] == arr[j].first && str[i + 3] == arr[j].second) {
                    str[i + 1] = '*';
                    str[i + 2] = '*';
                    break;
                }
            }
        }
        cout << str << "\n";
    }
    return 0;
}