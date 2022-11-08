#include<iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;


bool seat[102];

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int N; cin >> N;
    int cnt = 0;
    while (N--){
        int temp; cin >> temp;
        if (seat[temp] == true) cnt++;
        else seat[temp] = true;
    }
    cout << cnt;
    return 0;
}