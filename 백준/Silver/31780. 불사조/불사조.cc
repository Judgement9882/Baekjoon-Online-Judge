#include <iostream>
#include <queue>
#include <cmath>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int X, M; cin >> X >> M;
    queue<double> q;
    int ans = X;
    q.push(X);
    while (M--) {
        int qsize = q.size();
        while (qsize--) {
            double cur = q.front();
            q.pop();

            int a = floor(cur / 2);
            int b = ceil(cur / 2);

            ans += a;
            ans += b;
            q.push(a);
            q.push(b);
        }
    }

    cout << ans;
    return 0;
}