/*
    https://www.acmicpc.net/problem/1388

    바닥 장식
*/


#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool vis[52][52];
char board[52][52];

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, M;
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        fill(vis[i], vis[i] + M, 0);
        fill(board[i], board[i] + M, ' ');
    }

    for (int i = 0; i < N; i++) {
        string temp; cin >> temp;
        for (int j = 0; j < M; j++) {
            board[i][j] = temp[j];
        }
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            // 방문했다면
            if (vis[i][j] == 1) continue;


            if (board[i][j] == '-') {
                vis[i][j] = 1; // 방문
                cnt++; // 카운트
                int hor = j+1;
                while (board[i][hor] == '-' && hor < M) {
                    vis[i][hor] = 1;
                    hor++;
                }
            }

            else if (board[i][j] == '|'){
                vis[i][j] = 1; // 방문
                cnt++; // 카운트
                int ver = i + 1;
                while (board[ver][j] == '|' && ver < N) {
                    vis[ver][j] = 1;
                    ver++;
                }
            }

        }
    }
    cout << cnt;

    return 0;
}
