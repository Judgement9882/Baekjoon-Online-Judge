#include <bits/stdc++.h>
#define MAX_N 100001
using namespace std;
int N, K, ans1, ans2;

bool vis[MAX_N];

void bfs() {
    queue<pair<int, int>> q;
    q.push({ N, 0 });
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        vis[cur.first] = true;
        if (cur.first == K) {
            if (ans2 == 0) { // not visited
                ans1 = cur.second;
                ans2++;
            }
            else if (ans2 > 0 && ans1 == cur.second) { // already visited
                ans2++;
            }
        }

        int nx[3] = { cur.first - 1 , cur.first + 1, cur.first * 2 };
        for (auto k : nx) {
            if (k < 0 || k >= MAX_N || vis[k]) continue;
            q.push({ k, cur.second + 1 });
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> K;
    ans1 = 0, ans2 = 0;
    if (N == K) cout << 0 << "\n" << 1;
    else {
        bfs();
        cout << ans1 << "\n" << ans2;
    }
    return 0;
}