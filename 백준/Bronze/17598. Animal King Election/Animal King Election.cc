#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int nine = 9;
    unordered_map<string, int> map;
    vector<string> arr;
    while (nine--) {
        string str; cin >> str;
        if (map.find(str) == map.end()) {
            map[str] = 1;
            arr.push_back(str);
        }
        else {
            map[str]++;
        }
    }

    int num = 0;
    string ans;
    for (auto k : arr) {
        if (map[k] > num) {
            num = map[k];
            ans = k;
        }
    }
    cout << ans;
    
    return 0;
}