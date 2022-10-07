/*
    https://www.acmicpc.net/problem/20056

    마법사 상어와 파이어볼
*/

#include <iostream>
#include <vector>

using namespace std;

struct FIREBALL {
    int x, y;
    int m, s, d;
};

int N, M, K;
int dx[8] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int dy[8] = { 0, 1, 1, 1, 0, -1, -1, -1 };

vector<FIREBALL> ball;
vector<int> board[52][52];

void move() {
    vector<int> new_board[52][52];
    for (int i = 0; i < ball.size(); i++) {
        int dir = ball[i].d;

        // 속도는 1000까지인데 N의 범위가 50이므로 모듈러연산
        int speed = ball[i].s % N; 
        
        // 음수가 나올수 있으므로 +N을 하고 N으로 모듈러
        int nx = (ball[i].x + (dx[dir] * speed) + N) % N;
        int ny = (ball[i].y + (dy[dir] * speed) + N) % N;

        new_board[nx][ny].push_back(i); // 해당 인덱스의 볼은 해당 위치에 있음
        ball[i].x = nx;
        ball[i].y = ny;
    }

    // board update
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
            board[x][y] = new_board[x][y];
        }
    }
}

void sum() {
    // 겹치는건 new_ball로 만들어서 갱신
    vector<FIREBALL> new_ball;
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
            // vector<int> 로 index를 추가해줬기 때문에 
            // board[x][y] 로 접근 가능
            if (board[x][y].size() == 0) continue;

            // 하나 있는 경우(겹치지 않음)
            if (board[x][y].size() == 1) {
                // 하나밖에 없으므로 0번째는 인덱스(볼의 인덱스)
                int idx = board[x][y][0]; 
                new_ball.push_back(ball[idx]);
                continue;
            }

            // 겹치는 경우 (2개이상)
            int sum_m = 0, sum_s = 0;
            bool odd = true, even = true;
            for (int i = 0; i < board[x][y].size(); i++) {
                int idx = board[x][y][i];

                sum_m += ball[idx].m;
                sum_s += ball[idx].s;
                
                if (ball[idx].d % 2 == 0) {
                    odd = false; // 짝수
                }
                else {
                    even = false; // 홀수
                }
            }

            // 새로 만들어진 볼의 질량이 0이면
            if (sum_m / 5 == 0) continue;

            // 질량이 1이상이면 4개로 쪼개짐
            int new_m = sum_m / 5;
            int new_s = sum_s / board[x][y].size();
            for (int i = 0; i < 4; i++) {
                // 둘 중 하나가 true이면 모두 짝수이거나 모두 홀수
                if (odd || even) {
                    // 0 2 4 6 디렉션 넣음
                    new_ball.push_back({ x, y, new_m, new_s, i * 2 });
                }
                else {
                    // 1, 3, 5, 7
                    new_ball.push_back({ x, y, new_m, new_s, i * 2 + 1 });
                }
            }
        }
    }

    ball = new_ball;
}

int solve() {
    while (K--) {
        move();
        sum();
    }

    int ret = 0;
    for (int i = 0; i < ball.size(); i++) {
        ret += ball[i].m;
    }
    return ret;
}

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M >> K;
    for (int i = 0; i < M; i++) {
        int x, y, m, s, d;
        cin >> x >> y >> m >> s >> d;
        x--; y--;
        ball.push_back({ x, y, m, s, d });
        board[x][y].push_back(i);
    }

    int ret = solve();
    cout << ret;

    return 0;
}
