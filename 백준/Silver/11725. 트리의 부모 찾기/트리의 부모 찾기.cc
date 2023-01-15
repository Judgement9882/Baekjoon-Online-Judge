#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int N;
vector<int> adj[100002];
int p[100002];

void dfs(int cur) {
    for (int nxt : adj[cur]) {
        if (p[cur] == nxt) continue; // 이미 부모가 있으면
        p[nxt] = cur;
        dfs(nxt);
    }
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    for (int i = 0; i < N-1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1); // 루트는 1
    
    for (int i = 2; i <= N; i++) cout << p[i] << "\n";

    return 0;
}