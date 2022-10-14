/*
    https://www.acmicpc.net/problem/20057

    마법사 상어와 토네이도
    출처 : https://www.youtube.com/watch?v=YsxbYX1R3ww
*/

#include <iostream>
using namespace std;

int N;
int board[499][499];
int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { -1, 0, 1, 0 };


// 시작점을 기준으로 x, y 좌표
int windX[4][9] = {
    {-1, 1, -2, 2, -1, 1, -1, 1, 0},    // left
    {-1, -1, 0, 0, 0, 0, 1, 1, 2},      // down
    {1, -1, 2, -2, 1, -1, 1, -1, 0},    // right
    {1, 1, 0, 0, 0, 0, -1, -1, -2}      // up
};

int windY[4][9] = {
    {1, 1, 0, 0, 0, 0, -1, -1, -2},     // left
    {-1, 1, -2, 2, -1, 1, -1, 1, 0},    // down
    {-1, -1, 0, 0, 0, 0, 1, 1, 2},      // right
    {1, -1, 2, -2, 1, -1, 1, -1, 0}     // up
};

int rate[9] = { 1, 1, 2, 2, 7, 7, 10, 10, 5 };

int move(int x, int y, int dir) {
    int out_of_sand = 0;
    int sand = board[x][y];
    int sum = 0;
    for (int i = 0; i < 9; i++) {
        int nx = x + windX[dir][i];
        int ny = y + windY[dir][i];

        // 해당 칸에 머물 수 있는 모래값을 구함
        int wind_sand = (sand * rate[i]) / 100;
        sum += wind_sand;

        // 나갔다면
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            out_of_sand += wind_sand;
            continue;
        }

        // 나가지 않으면 해당칸에 더함
        board[nx][ny] += wind_sand;
    }

    // a 위치 구하기
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    int a = sand - sum;

    // a 가 만약 맵 밖이라면 더해줌
    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
        out_of_sand += a;
    }
    else {
        board[nx][ny] += a;
    }

    // 이미 이동한 칸은 0으로 초기화
    board[x][y] = 0;
    return out_of_sand;
}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    int cx = N / 2, cy = N / 2;
    int dir = -1, ret = 0;
    bool visited[499][499] = { false, };

    while ((cx != 0) || (cy != 0)) {
        visited[cx][cy] = true;
        
        int nd = (dir + 1) % 4;
        int nx = cx + dx[nd];
        int ny = cy + dy[nd];
        // 이미 방문한 칸이면
        if (visited[nx][ny] == true) {
            nd = dir;
            nx = cx + dx[nd];
            ny = cy + dy[nd];
        }
        
        ret += move(nx, ny, nd);
        cx = nx; cy = ny; dir = nd;
    }
    cout << ret;
    return 0;
}
