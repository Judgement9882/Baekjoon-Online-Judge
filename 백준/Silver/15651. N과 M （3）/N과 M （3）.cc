#include <iostream>
#include <vector>

using namespace std;

vector<int> v;

// bool visit[9];


void solve(int N, int M, int cnt) {
    if (cnt == M) {
        for (int i = 0; i < v.size(); i++) {
            cout << v[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= N; i++) {

        //if (visit[i]) {
        //    continue; // 방문한 곳이면 넘어감
        //}

        // visit[i] = 1;
        v.push_back(i);
        solve(N, M, cnt + 1);
        // visit[i] = 0;
        v.pop_back();
    }
}

int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    cin >> N >> M;

    solve(N, M, 0);


    return 0;
}