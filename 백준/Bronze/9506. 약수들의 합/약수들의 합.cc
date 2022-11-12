#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    while (1) {
        int N; cin >> N;
        if (N == -1) break;

        int cnt = 0;

        queue<int> q;
        
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                cnt += i;
                q.push(i);
            }
        }

        int temp;
        if (cnt != N-1) cout << N << " is NOT perfect.\n";
        else {
            cout << N << " = 1 + ";
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {

                // 마지막이라면
                if (q.size() == 1) {
                    temp = q.front(); q.pop();
                    cout << temp;
                }
                else {
                    temp = q.front(); q.pop();
                    cout << temp << " + ";
                }
            }
            cout << "\n";
        }
    }
    


    return 0;
}