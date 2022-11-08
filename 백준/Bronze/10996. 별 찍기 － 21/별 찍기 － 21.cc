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
    
    // 전체 반복
    for (int i = 0; i < N; i++) {
        
        // 홀수 줄
        for (int j = 0; j < N; j++) {
            if (j % 2 == 0) cout << "*";
            else cout << " ";
        }
        cout << "\n";
        for (int j = 0; j < N; j++) {
            if (j % 2 == 1) cout << "*";
            else cout << " ";
        }
        cout << "\n";
    }


    return 0;
}