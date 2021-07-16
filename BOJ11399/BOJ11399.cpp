#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {

    // I/O speed management
    cin.tie(0);
    ios_base::sync_with_stdio(0);

    int N;
    cin >> N;

    vector<int> num;

    for (int i = 0; i < N; i++) {
        int v;
        cin >> v;
        num.push_back(v);
    }

    sort(num.begin(), num.end());

    int sum = 0;

    for (int i = 0; i < N; i++) {
        sum += num[i] * (N - i);
    }
    cout << sum;

    //int* num = new int[N];

    //for (int i = 0; i < N; i++) {
    //    int v;
    //    cin >> v;
    //    num[i] = v;
    //}

    //sort(num, num + N);

    //int cnt = 0;


    //for (int i = 0; i < N; i++) {
    //    cnt += num[i] * (N - i);
    //}
    //cout << cnt;

    return 0;
}