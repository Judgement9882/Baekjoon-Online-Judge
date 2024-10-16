#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while (T--) {
        int N; cin >> N;
        vector<int> arr;
        for (int i = 0; i < N; i++) {
            int num; cin >> num;
            arr.push_back(num);
        }

        sort(arr.begin(), arr.end());

        vector<int> front;
        int big = arr[N - 1];
        vector<int> back;

        for (int i = 0; i < N - 1; i++) {
            if (i % 2 == 0) front.push_back(arr[i]);
            else back.push_back(arr[i]);
        }

        int ans = 0;
        
        int f = front[0], b;
        int fLen = front.size();
        for (int i = 1; i < fLen; i++) {
            b = front[i];
            ans = max(ans, b - f);
            f = front[i];
        }

        ans = max(ans, big - f);
        f = big;
        int bLen = back.size();

        for (int i = bLen -1 ; i >= 0; i--) {
            b = back[i];
            ans = max(ans, f - b);
            f = back[i];
        }

        ans = max(ans, b - front[0]);

        cout << ans << "\n";
    }
    return 0;
}