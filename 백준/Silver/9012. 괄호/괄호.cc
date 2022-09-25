/*
    https://www.acmicpc.net/problem/9012

    괄호
*/


#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int T; cin >> T;

    stack<char> vps;

    while (T--) {
        while (!vps.empty()) vps.pop();

        string temp;
        cin >> temp;
        int flag = 0;
        for (int i = 0; i < temp.length(); i++) {

            // 비어있을경우
            if (vps.empty()) {
                if (temp[i] == ')') {
                    flag = 1;
                    break;
                }
                vps.push(temp[i]);
            }

            // 하나라도 있을경우
            else if (vps.top() == '(') {
                if (temp[i] == '(') vps.push(temp[i]);
                else vps.pop();
            }
            
        }
        if (flag || !vps.empty()) cout << "NO\n";
        else cout << "YES\n";
    }
    return 0;
}
