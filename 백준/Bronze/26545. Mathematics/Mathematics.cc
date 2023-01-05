#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    long long N; cin >> N;
    long long cnt = 0;
    for (long long i = 0; i < N; i++) {
        long long temp; cin >> temp;
        cnt += temp;
    }
    cout << cnt;
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}