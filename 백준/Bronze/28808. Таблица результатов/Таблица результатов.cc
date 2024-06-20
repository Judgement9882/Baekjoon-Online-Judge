#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m; cin >> n >> m;
    int num = 0;
    while (n--) {
        string answer; cin >> answer;
        for (int i = 0; i < answer.length(); i++) {
            if (answer[i] == '+') {
                num++;
                break;
            }
        }
    }
    cout << num;
    return 0;
}