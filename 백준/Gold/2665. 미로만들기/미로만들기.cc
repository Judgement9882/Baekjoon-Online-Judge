#include <iostream>
#include <string>
#include <queue>

#define MAX_N 51
#define INF 1e9

using namespace std;

struct Node{
    int x;
    int y;
    int changeNum;

    Node(int _x, int _y, int _changeNum){
        this->x = _x;
        this->y = _y;
        this->changeNum = _changeNum;
    }
};

int N, ans;
int board[MAX_N][MAX_N], vis[MAX_N][MAX_N];
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};



int solve(){
    queue<Node> q;
    vis[0][0] = 0;
    q.push(Node(0, 0, 0));

    while(!q.empty()){
        Node cur = q.front();
        q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            int changeNum = cur.changeNum;
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            // 변경 횟수가 클 경우 방문할 필요 x
            if(vis[nx][ny] != INF && vis[nx][ny] <= changeNum) continue;
            vis[nx][ny] = changeNum;
            // 검은방인 경우
            if(board[nx][ny] == 0) q.push(Node(nx, ny, changeNum+1));
            else q.push(Node(nx, ny, changeNum));
        }
    }

    return vis[N-1][N-1];
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N;
    for(int i = 0; i < N; i++){
        string temp; cin >> temp;
        for(int j = 0; j < temp.length(); j++){
            board[i][j] = temp[j] - '0'; // 방 정보
            vis[i][j] = INF; // 방문횟수 초기화
        }
    }
    
    cout << solve();
    return 0;
}