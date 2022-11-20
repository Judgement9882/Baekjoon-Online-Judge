#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int N, M;

bool vis[1001];
bool board[1001][1001];

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        board[a][b] = 1;
        board[b][a] = 1;
    }
    
    
    int cnt = 0;
    for (int i = 1; i <= N; i++) {

        // 방문하지 않았다면
        if (!vis[i]) {
            cnt++;
            queue<int> Q;
            Q.push(i);
            
            while (!Q.empty()) {
                int cur = Q.front(); Q.pop();
                if (vis[cur]) {
                    continue;
                }

                vis[cur] = 1;
                for (int j = 1; j <= N; j++) {
                    if (!vis[j] && board[cur][j]) {
                        Q.push(j);
                    }
                }
            }

        }
    }

    cout << cnt;
    return 0;
}