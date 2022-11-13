#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;



int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    
    int N; cin >> N;
    for (int i = N; i > 0; i--) {
        int temp = i;
        bool flag = true;
        while (temp > 0) {
            if (temp % 10 == 7 || temp % 10 == 4) {
                temp /= 10;
                continue;
            }

            flag = false;
            break;
        }

        if (flag) {
            cout << i;
            break;
        }
    }
    


    return 0;
}