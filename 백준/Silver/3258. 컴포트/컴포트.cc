#include <iostream>
#include <algorithm>
using namespace std;
bool vis[1002];
bool no[1002];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, Z, M; 
    cin >> N >> Z >> M;
    while (M--) {
        int i; 
        cin >> i; 
        no[i] = true;
    }
    for (int i = 1; i < N; i++) {
        int start = 1;
        vis[start] = true;
        bool ans = false;
        fill(vis, vis + 1001, false);
        while (true) {
            start += i;
            if (start > N) start -= N;
            if (start == Z) {
                ans = true;
                break;
            }
            if (no[start] || vis[start]) {
                break;
            }
            vis[start] = true;
        }
        if (ans) {
            cout << i;
            break;
        }
    }
    return 0;
}