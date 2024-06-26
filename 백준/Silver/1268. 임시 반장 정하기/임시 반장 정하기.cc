#include <iostream>
#include <vector>
#include <map>
#include <set>
using namespace std;
int student[1002][5];
map<pair<int, int>, vector<int>> score;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> student[i][j];
            score[{j, student[i][j]}].push_back(i);
        }
    }

    int temp = 0;
    int ans = 0;
    for (int i = 1; i <= N; i++) {
        set<int> temp_stu;
        for (int j = 0; j < 5; j++) {
            for (auto k : score[{j, student[i][j]}]) {
                temp_stu.insert(k);
            }
        }

        if (temp_stu.size() > temp) {
            ans = i;
            temp = temp_stu.size();
        }
    }

    cout << ans;
    return 0;
}