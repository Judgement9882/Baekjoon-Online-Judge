#include<iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    int cnt = 0;
    while (N--) {
        int A, B; cin >> A >> B;
        cnt += B % A;
    }
    cout << cnt;


    return 0;
}