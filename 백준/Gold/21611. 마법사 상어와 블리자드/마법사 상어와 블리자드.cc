/*
    https://www.acmicpc.net/problem/

    마법사 상어와 블리자드
    출처 : na982
*/

#include <iostream>
#include <vector>

using namespace std;

// 0 1 2 3
int dx[4] = { 0, -1, 1, 0 };
int dy[4] = { 1, 0, 0, -1 };

int line_size;
int line[2500];
int board[50][50];
int N, M, ret = 0;
pair<int, int> shark;

void blizard(int d, int s){
    for (int i = 1; i <= s; i++) {
        int nx = shark.first + dx[d] * i;
        int ny = shark.second+ dy[d] * i;

        board[nx][ny] = 0;
    }
}

void convertToLine() {
    int ddx[4] = { 0, 1, 0, -1 };
    int ddy[4] = { -1, 0, 1, 0 };
    
    int cx = shark.first;
    int cy = shark.second;
    line_size = 0;

    int d = 0; // 왼쪽부터 시작
    int loop_count = 2; // 두번마다 바뀌어야함.
    for (int dist = 1; dist < N; dist++) {
        // 마지막이면 3번 넣으므로 loop_count를 바꿔줌
        if (dist == N - 1) loop_count = 3;
        
        for (int i = 0; i < loop_count; i++) {
            for (int j = 0; j < dist; j++) {
                cx += ddx[d];
                cy += ddy[d];
                // 0이 아니면 일차원 배열에 넣음
                if (board[cx][cy] != 0) {
                    line[line_size++] = board[cx][cy];
                }
            }

            // dist 만큼 돌면 방향을 바꿔줘야함.
            d = (d + 1) % 4;
        }
    }
}

// 공백을 없앰
void blank() {
    int new_line_size = 0;
    int new_line[2500] = { 0, };

    for (int i = 0; i < line_size; i++) {
        if (line[i] != 0) {
            new_line[new_line_size++] = line[i];
        }
    }

    for (int i = 0; i < new_line_size; i++) {
        line[i] = new_line[i];
    }
    line_size = new_line_size;
}

int boom() {
    // 구슬을 가리킬 포인터
    int point = 0;

    // 뒤에거와 개수를 비교하는 변수
    int count = 1;

    for (int i = 1; i < line_size; i++) {
        // 연속
        if (line[i - 1] == line[i]) count++;
        else {
            // 이미 4개 이상 나왔으면 처리
            if (count >= 4) {
                for (int j = 1; j <= count; j++) {
                    point += line[i - j];
                    line[i - j] = 0;
                }
            }
            // 아니면 초기화
            count = 1;
        }

       
    }
    // 마지막을 파괴해줘야 하는지 확인
    if (count >= 4) {
        for (int j = 1; j <= count; j++) {
            point += line[line_size - j];
            line[line_size - j] = 0;
        }
    }

    ret += point;
    return point;
}

// 수의 개수만큼 반환
void change_num() {
    int back_size = 0;
    int back[2500] = { 0, };
    int count = 1;
    for (int i = 1; i < line_size; i++) {
        if (line[i - 1] == line[i]) count++;

        else {

            // 확장하다보면 원본 배열의 크기보다 커질수있음. 그러면 버려야함
            if (back_size < N * N - 2) {
                back[back_size++] = count;
                back[back_size++] = line[i - 1];
            }

            count = 1;
        }
    }

    // 마지막은 안걸림
    // line_size = 0 : 구슬이 아무것도 안들어가있음
    if (line_size > 0 && back_size < N * N - 2) {
        back[back_size++] = count;
        back[back_size++] = line[line_size - 1];
    }
    for (int i = 0; i < back_size; i++) {
        line[i] = back[i];
    }
    line_size = back_size;
}

void convertToMat() {
    int ddx[4] = { 0, 1, 0, -1 };
    int ddy[4] = { -1, 0, 1, 0 };

    int cx = shark.first;
    int cy = shark.second;

    int d = 0; // 왼쪽부터 시작

    int loop_count = 2; // 두번마다 바뀌어야함.

    // 1차원 배열에서 현재 포인터
    int cur = 0;

    for (int dist = 1; dist < N; dist++) {
        // 마지막이면 3번 넣으므로 loop_count를 바꿔줌
        if (dist == N - 1) loop_count = 3;

        for (int i = 0; i < loop_count; i++) {
            for (int j = 0; j < dist; j++) {
                cx += ddx[d];
                cy += ddy[d];
                // 0이 아니면 일차원 배열에 넣음
                
                if (cur < line_size) {
                    board[cx][cy] = line[cur++];
                }
                // cur을 다 채웠는데 board가 안채워진 경우 0으로 채움
                else {
                    board[cx][cy] = 0;
                }
            }

            // dist 만큼 돌면 방향을 바꿔줘야함.
            d = (d + 1) % 4;
        }
    }
}


int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M;
    shark = { N / 2, N / 2 };
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }
    
    while (M--) {
        int d, s;
        cin >> d >> s;
        blizard(d%4, s);
        convertToLine();
        while (boom() != 0) {
            blank();
        }
        blank();
        change_num();
        convertToMat();


    }

    cout << ret;

    return 0;
}
