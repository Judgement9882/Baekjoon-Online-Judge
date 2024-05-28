// https://blog.encrypted.gg/499 참고
#include <iostream>
using namespace std;

int T, n;
int want[100002];
int vis[100002];

#define NOT_VISITED 0
#define VISITED 1
#define CYCLE 2
#define NOT_CYCLE 3

void check(int student) {
    int cur = student;
    while (true) {
        // 다음으로 이동하면서 방문 처리.
        vis[cur] = VISITED;
        cur = want[cur];

        // 1. 방문 처리를 하다, student가 아닌, 다른 학생이 방문했다면?
        // => 다른 학생은 cycle이고, x는 cycle이 아님.
        // ==> 다른 학생에서 출발해 다른 학생까지 CYCLE로 만들고
        // ==> student에서 출발해 다른 학생 전까지 NOT CYCLE로 바꾸기
        if (vis[cur] == VISITED && cur != student) {
            while (vis[cur] != CYCLE) {
                vis[cur] = CYCLE;
                cur = want[cur];
            }
            // 처음 학생으로 바꾸기
            cur = student;
            while (vis[cur] != CYCLE) {
                vis[cur] = NOT_CYCLE;
                cur = want[cur];
            }
            return;
        }

        // 2. 다음칸이 싸이클이거나 싸이클이 아닐 경우
        // => student는 싸이클을 못 만듦.
        if (vis[cur] == CYCLE || vis[cur] == NOT_CYCLE) {
            // student로 돌아와서 방문이 된 칸에 싸이클 유무 입력
            cur = student;
            while (vis[cur] == VISITED) {
                vis[cur] = NOT_CYCLE;
                cur = want[cur];
            }
            return;
        }

        // 3. student를 재방문하면 student 포함, 그 경로는 전부 CYCLE
        if (vis[cur] == VISITED && cur == student) {
            while (vis[cur] != CYCLE) {
                vis[cur] = CYCLE;
                cur = want[cur];
            }
            return;
        }        
    }
    // 이미 방문한 노드를 방문할 경우, 탐색 종료 후, 작업 진행 => O(N)
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    while (T--) {
        cin >> n;
        fill(vis, vis+ n + 1, 0);
        for (int i = 1; i <= n; i++) cin >> want[i];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // 방문 안했으면 체크
            if (vis[i] == NOT_VISITED) check(i);
        }
        for (int i = 1; i <= n; i++) {
            // 싸이클이 아니면
            if (vis[i] == NOT_CYCLE) ans++;
        }
        cout << ans << "\n";
    }
    return 0;
}