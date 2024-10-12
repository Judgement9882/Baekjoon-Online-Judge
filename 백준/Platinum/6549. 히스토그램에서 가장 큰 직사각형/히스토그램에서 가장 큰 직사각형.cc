#include <bits/stdc++.h>
using namespace std;
vector<long long> height;

long long solve(int left, int right) {
    if (left == right) return height[left];
    int mid = (left + right) / 2;
    long long ret = max(solve(left, mid), solve(mid + 1, right));
    int lo = mid, hi = mid + 1;
    long long h = min(height[lo], height[hi]);
    ret = max(ret, h * 2);
    
    while (left < lo || hi < right) {
        if (hi < right && (lo <= left || height[lo - 1] < height[hi + 1])) {
            hi++;
            h = min(h, height[hi]);
        }
        else {
            lo--;
            h = min(h, height[lo]);
        }
        ret = max(ret, h * (hi - lo + 1));
    }
    return ret;
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    while (true) {
        int N; cin >> N;
        if (N == 0) break;
        for (int i = 0; i < N; i++) {
            long long num;
            cin >> num;
            height.push_back(num);
        }

        cout << solve(0, N - 1) << "\n";
        height.clear();
    }
    
    
    return 0;
}