#include <iostream>
#include <string>
#include <queue>

#define MAX_NM 50

using namespace std;

int N, M;
char board[MAX_NM][MAX_NM];
bool vis[MAX_NM][MAX_NM];
int dx[4] = { 0, 1, 0, -1 }, dy[4] = {1, 0, -1, 0};

struct Pos {
    int x, y;
    Pos(int _x, int _y) {
        this->x = _x;
        this->y = _y;
    }
};

void initVis() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            vis[i][j] = false;
        }
    }
}

int bfs(int x, int y) {
    initVis();
    int ret = 0;
    queue<pair<Pos, int>> q;
    q.push({ Pos(x, y), 0});
    vis[x][y] = true;
    while (!q.empty()) {
        Pos cur = q.front().first;
        int dist = q.front().second;
        
        q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (vis[nx][ny] || board[nx][ny] == 'W') continue;
            
            q.push({ Pos(nx, ny), dist + 1 });
            vis[nx][ny] = true;
            ret = max(ret, dist+1);
        }
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        string temp; cin >> temp;
        for (int j = 0; j < M; j++) {
            board[i][j] = temp[j];
        }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 'L') {
                ans = max(ans, bfs(i, j));
            }
        }
    }
    cout << ans;
    return 0;
}