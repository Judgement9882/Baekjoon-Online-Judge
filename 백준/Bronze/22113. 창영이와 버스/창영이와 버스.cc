#include <iostream>
#include <vector>
#define MAX_N 101
using namespace std;
int N, M;
int fair[MAX_N][MAX_N];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    vector<int> route(M);
    for (int i = 0; i < M; i++) cin >> route[i];
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> fair[i][j];
        }
    }

    int ans = 0;
    for (int i = 0; i < M - 1; i++) {
        ans += fair[route[i]][route[i + 1]];
    }
    cout << ans;
    return 0;
}