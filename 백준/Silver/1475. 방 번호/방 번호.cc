#include <iostream>
#include <vector>
#include <algorithm>
#include <string>


using namespace std;

int main() {

    // 입출력 속도 관리
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string N;
    cin >> N;

    int plastic[10] = {};

    for (int i = 0; i < N.length(); i++) {
        plastic[N[i] - '0']++;
    }

    int cnt1 = 0;
    int cnt2 = 0;
    

    for (int i = 0; i < 10; i++) {
        if (i == 6 || i == 9) {
            cnt2 += plastic[i];
        }
        else {
            cnt1 = max(cnt1, plastic[i]);
        }
    }

    if (cnt2 % 2 == 0) {
        cnt2 /= 2;  
    }
    else {
        cnt2 = cnt2 / 2 + 1;
    }

    cout << max(cnt2, cnt1);

    return 0;
}