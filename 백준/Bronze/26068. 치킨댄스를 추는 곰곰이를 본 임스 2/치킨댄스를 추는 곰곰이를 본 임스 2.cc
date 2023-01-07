#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N; cin >> N; int cnt = 0;
    for (int i = 0; i < N; i++) {
        string temp; cin >> temp;
        if (temp.length() == 3) { // D-3
            cnt++;
        }
        else if(temp.length() == 4) {
            if (temp[2] - '0' <= 8) cnt++;
            else {
                if (temp[3] - '0' == 0) cnt++;
            }
        }
    }
    cout << cnt;
    return 0;
}