#include <iostream>
#include <unordered_set>
#define MAX_N 21
using namespace std;

int N, max_num;
int arr[MAX_N];
unordered_set<int> set;
bool vis[MAX_N];

void func(int cnt, int sum) {
    if (cnt == N) {
        set.insert(sum);
        return;
    }

    func(cnt + 1, sum + arr[cnt]);
    func(cnt + 1, sum);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    max_num = 0;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        max_num += arr[i];
    }

    func(0, 0);
    cout << max_num - set.size() + 1;

    return 0;
}