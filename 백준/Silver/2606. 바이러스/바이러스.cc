#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int N, link, cnt = -1;

bool vis[101];
bool board[101][101];

void dfs(int n) {
    vis[n] = 1; // 방문
    cnt++;
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
    
    cin >> N >> link;
    for (int i = 0; i < link; i++) {
        int a, b; cin >> a >> b;
        board[a][b] = 1;
        board[b][a] = 1;
    }
    
    dfs(1);
    cout << cnt;
    
    return 0;
}