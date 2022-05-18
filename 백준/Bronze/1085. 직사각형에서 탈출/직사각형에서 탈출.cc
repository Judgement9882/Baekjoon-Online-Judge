#include <iostream>

using namespace std;


int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
   
    int x,y,w,h;
    cin >> x >> y; // 한수의 위치
    cin >> w >> h; // 오른쪽 위 꼭짓점.

    // 내부에 있는 경우
    if (x >= 0 && x <= w && y >= 0 && y <= h) {
        int distance = x;
        if (distance > w-x) {
            distance = w-x;
        }
        if (distance > y) {
            distance = y;
        }
        if (distance > h - y) {
            distance = h - y;
        }
        cout << distance;
    }


    


    return 0;
}