#include <iostream>
#include <vector>

using namespace std;
int ans[11];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    for (int i = 1; i <= 10; i++) {
        ans[i] = ((i - 1) % 5) + 1;
    }
   
    vector<int> stu;
    int N; cin >> N;
    for (int i = 1; i <= N; i++) {
        bool re = true;
        for (int j = 1; j <= 10; j++) {
            int num; cin >> num;
            if (num != ans[j]) re = false;
        }
        if (re) stu.emplace_back(i);
    }

    for (auto k : stu) {
        cout << k << "\n";
    }

    return 0;
}