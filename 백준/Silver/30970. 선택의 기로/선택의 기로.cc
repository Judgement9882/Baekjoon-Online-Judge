#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// sort function
bool first_f(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.first != b.first)
        return a.first > b.first;
    return a.second < b.second;
}

bool second_f(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second != b.second)
        return a.second < b.second;
    return a.first > b.first;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    vector<pair<int, int>> mini;
    for (int i = 0; i < N; i++) {
        int Q, P; cin >> Q >> P;
        mini.push_back({ Q, P });
    }
    sort(mini.begin(), mini.end(), first_f);
    cout << mini[0].first << " " << mini[0].second << " " << mini[1].first << " " << mini[1].second << "\n";
    sort(mini.begin(), mini.end(), second_f);
    cout << mini[0].first << " " << mini[0].second << " " << mini[1].first << " " << mini[1].second << "\n";
    return 0;
}