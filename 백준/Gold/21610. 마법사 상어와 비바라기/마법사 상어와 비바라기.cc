/*
    https://www.acmicpc.net/problem/21610

    마법사 상어와 비바라기
    출처 : https://www.youtube.com/watch?v=ZbJUP71bd3Q
*/

#include <iostream>
using namespace std;

struct CLOUD {
    int x, y;
    
    
};

int dx[8] = { 0, -1, -1, -1, 0, 1, 1, 1};
int dy[8] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int N, M;
int cloud_size;
CLOUD cloud[2500]; // 구름의 좌표 저장
int cloud_map[50][50];
int board[50][50];

// 생성하면 cloud에 좌표 저장
void create_cloud(int x, int y) {
    cloud[cloud_size].x = x;
    cloud[cloud_size].y = y;
    cloud_size++;
}

// 구름 생성
void init_cloud() {
    create_cloud(N - 2, 0);
    create_cloud(N - 2, 1);
    create_cloud(N - 1, 0);
    create_cloud(N - 1, 1);
}

void move_cloud(int d, int s) {
    // 범위를 벗어날 수 있고 음수일수 있으니까 N*50 더하고 나중에 N으로 모듈러
    int nx = dx[d] * s + (N * 50);
    int ny = dy[d] * s + (N * 50);

    for (int i = 0; i < cloud_size; i++) {
        cloud[i].x = (nx + cloud[i].x) % N;
        cloud[i].y = (ny + cloud[i].y) % N;
    }
}

// 물 증가
void increase_water() {
    for (int i = 0; i < cloud_size; i++) {
        board[cloud[i].x][cloud[i].y]++;
    }
}
// 구름 지우기
void delete_cloud() {    
    // 구름이 있었던 위치는 새로 구름이 생성되지 않아야함.
    // 따라서 기억할 cloud_map 설정

    // init
    for (int i = 0; i < 50; i++) {
        for (int j = 0; j < 50; j++) {
            cloud_map[i][j] = 0;
        }
    }

    for (int i = 0; i < cloud_size; i++) {
        cloud_map[cloud[i].x][cloud[i].y] = 1;
    }

    cloud_size = 0;
}

// 물 복사 버그
void water_copy_bug() {
    int increase_water[50][50] = { 0, };
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (cloud_map[i][j] == 1) // 물이 있으면 대각선 방향으로 체크해야함
            {
                int count = 0;
                // 대각선만 돌거라서 홀수만
                for (int d = 1; d < 8; d += 2) {
                    int nx = dx[d] + i;
                    int ny = dy[d] + j;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    // 물이 있을경우 증가
                    if (board[nx][ny] >= 1) count++;
                }

                increase_water[i][j] += count;
            }
        }
    }

    // 따로 배열을 만들어서 증가량을 구하고 한번에 더하는 이유
    // => count를 구할 때 원래 board에서 비교를 하기 때문에
    // 값이 변동되어 이상한 값이 들어갈 수 있음. 안전하게 하자.
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            board[i][j] += increase_water[i][j];
        }
    }
}
// 구름 생성
void generate_cloud() {
    // 구름이 있었던 칸이 아닌 칸을 기준으로
    // 물이 있었으면 물을 2개 빼주고 구름을 만들어줌.

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] >= 2 && cloud_map[i][j] == 0) {
                create_cloud(i, j);
                board[i][j] -= 2;
            }
        }
    }
}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    // 왼쪽아래 구름생성
    init_cloud();

    for (int i = 0; i < M; i++) {
        int d, s; cin >> d >> s;

        // 구름 이동
        move_cloud(d - 1, s);

        // 물 증가
        increase_water();
        // 구름 지우기
        delete_cloud();
        // 물 복사 버그
        water_copy_bug();
        // 구름 생성
        generate_cloud();

    }

    int ret = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            ret += board[i][j];
        }
    }
    cout << ret;
    return 0;
}
