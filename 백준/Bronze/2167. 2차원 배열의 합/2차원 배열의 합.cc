#include<iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int board[302][302];

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N, M; cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            cin >> board[i][j];
        }
    }
    
    int K; cin >> K;
    while (K--) {
        int cnt = 0;

        int i, j, x, y; cin >> i >> j >> x >> y;
        for (int a = i; a <= x; a++) {
            for (int b = j; b <= y; b++) {
                cnt += board[a][b];
            }
        }
        cout << cnt << "\n";
    }
    


    return 0;
}