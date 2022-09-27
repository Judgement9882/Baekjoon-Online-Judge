/*
    https://www.acmicpc.net/problem/11866

    요세푸스 0
*/


#include <iostream>
#include <queue>

using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, K; cin >> N >> K;
    
    queue<int> yos;

    for (int i = 1; i <= N; i++) {
        yos.push(i);
    }

    cout << '<';
    while (!yos.empty()) {
        for (int i = 0; i < K - 1; i++) {
            int temp = yos.front();
            yos.pop();
            yos.push(temp);
        }

        cout << yos.front();
        yos.pop();
        if (yos.size()) cout << ", ";
    }
    cout << '>';

    return 0;
}
