#include <bits/stdc++.h>
#define MAX_N 100001
using namespace std;
vector<int> in[MAX_N];
bool vis[MAX_N];
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N, M; cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int u, v; cin >> u >> v;
        in[v].push_back(u);
    }

    int ans = 0;
    int X; cin >> X;

    if (!in[X].empty()) {
        queue<int> q;
        for (auto k : in[X]) {
            q.push(k);
            vis[k] = true;
            ans++;
        }
        
        while (!q.empty()) {
            int cur = q.front(); q.pop();
            for (auto k : in[cur]) {
                if (vis[k]) continue;
                q.push(k);
                vis[k] = true;
                ans++;
            }
        }
    }

    cout << ans;
    return 0;
}