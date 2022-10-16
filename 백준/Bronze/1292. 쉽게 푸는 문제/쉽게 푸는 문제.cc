/*
    https://www.acmicpc.net/problem/1292

    쉽게 푸는 문제
*/

#include <iostream>
#include <vector>
using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);

    vector<int> v;
    v.push_back(0);
    int index = 1;
    while (1) {
        for (int i = 0; i < index; i++) {
            v.push_back(index);
        }
        index++;


        if (v.size() > 1000) break;
    }

    int A, B; cin >> A >> B;
    int cnt = 0;
    for (int i = A; i <= B; i++) {
        cnt += v[i];
    }
    cout << cnt;

    return 0;
}
