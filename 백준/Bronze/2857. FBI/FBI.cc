#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> ans;
    for (int i = 1; i <= 5; i++) {
        string str; cin >> str;
        for (int j = 0; j < str.length()-2; j++) {
            if (str[j] == 'F' && str[j + 1] == 'B' && str[j + 2] == 'I') {
                ans.push_back(i);
                break;
            }
        }
    }
    if (ans.empty()) cout << "HE GOT AWAY!";
    else {
        for (auto k : ans) cout << k << " ";
    }
    return 0;
}