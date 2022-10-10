/*
    https://www.acmicpc.net/problem/14888

    연산자 끼워넣기
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N; 
int A[12];
vector<char> opt_to_line;
bool isused[11];
int max_val = -0x7f7f7f7f, min_val=0x7f7f7f7f;

void func(int A_num, int k) {

    // 연산자를 N-1개 만큼 다 썼다면
    if (k == N - 1) {
        max_val = max(max_val, A_num);
        min_val = min(min_val, A_num);
        //cout << " = " << min_val << "\n";
        return;
    }

    // 연산자를 하나씩 사용
    for (int i = 0; i < N - 1; i++) {
        if (!isused[i]) {
            isused[i] = 1;
            if (opt_to_line[i] == '+') {
                func(A_num + A[k + 1], k + 1);
            }
            else if (opt_to_line[i] == '-') {
                func(A_num - A[k + 1], k + 1);
            }
            else if (opt_to_line[i] == '*') {
                func(A_num * A[k + 1], k + 1);
            }
            else if (opt_to_line[i] == '/') {
                func(A_num / A[k + 1], k + 1);
            }
            
            isused[i] = 0;
        }
    }

}


int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    // init
    while (!opt_to_line.empty()) opt_to_line.pop_back();
    fill(isused, isused + N, 0);


    for (int i = 0; i < 4; i++) {
        int temp; cin >> temp;
        if (i == 0) {
            while (temp--) {
                opt_to_line.push_back('+');
            }
        }
        else if (i == 1) {
            while (temp--) {
                opt_to_line.push_back('-');
            }
        }
        else if (i == 2) {
            while (temp--) {
                opt_to_line.push_back('*');
            }
        }
        else if (i == 3) {
            while (temp--) {
                opt_to_line.push_back('/');
            }
        }
    }

    
    func(A[0], 0);
    cout << max_val << "\n" << min_val;

    return 0;
}
