#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int N, link, V;

bool vis[1001];
bool board[1001][1001];

void dfs(int n) {
    cout << n << " ";
    vis[n] = 1; // 방문
    
    for (int i = 1; i <= N; i++) {
        // 방문하지 않고 연결되어있다면
        if (!vis[i] && board[n][i]) {
            dfs(i);
        }
    }

}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> link >> V;
    for (int i = 0; i < link; i++) {
        int a, b; cin >> a >> b;
        board[a][b] = 1;
        board[b][a] = 1;
    }
    
    dfs(V);
    cout << "\n";

    fill(vis, vis + 1001, 0);

    queue<int> Q;
    Q.push(V);
    while (!Q.empty()) {
        int cur = Q.front(); Q.pop();
        if (vis[cur]) {
            continue;
        }
        vis[cur] = 1;
        cout << cur << " ";
        

        for (int i = 1; i <= N; i++) {
            if (!vis[i] && board[cur][i]) {
                Q.push(i);
            }
        }
    }
    
    
    return 0;
}