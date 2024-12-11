#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    int ans = 1, temp = 1;
    for (int i = 1; i < N; i++) {
        if (arr[i] > arr[i - 1]) temp++;
        else temp = 1;
        ans = max(ans, temp);
    }
    cout << ans;
    return 0;
}