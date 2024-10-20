#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<pair<int, int>> dq;
    int N; cin >> N;
    for (int i = 1; i <= N; i++) {
        int num; cin >> num;
        dq.push_back({ i, num });
    }

    while (!dq.empty()) {
        pair<int, int> cur = dq.front();
        dq.pop_front();
        cout << cur.first << " ";

        int move = cur.second;
        if (move > 0) {
            while (!dq.empty() && --move) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else {
            move = -move;
            while (!dq.empty() && move--) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
    
    return 0;
}