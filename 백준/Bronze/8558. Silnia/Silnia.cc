#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N; cin >> N;
    // 1 => 1 , 2 => 2 , 3 => 6, 4 => 4 , 5 => 0 , 6 => 0

    if (N <= 1) cout << "1";
    else if (N == 2) cout << "2";
    else if (N == 3) cout << "6";
    else if (N == 4) cout << "4";
    else cout << "0";

    return 0;
}