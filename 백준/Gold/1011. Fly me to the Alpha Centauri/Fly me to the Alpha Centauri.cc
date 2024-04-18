#include <iostream>
#include <cmath>

using namespace std;


int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int T; // 테스트케이스
    cin >> T;
    
    for (int i = 0; i < T; i++) {

        int x, y;
        cin >> x >> y; // 현재위치와 목표위치

        int distance = y - x; // 사이 거리

        /*
            1, 2, 3 -> 1, 2, 3

            4 -> 1 2 1
            6 -> 1 2 2 1
            9 -> 1 2 3 2 1
            12 -> 1 2 3 3 2 1
            16 -> 1 2 3 4 3 2 1
            20 -> 1 2 3 4 4 3 2 1
            25 -> 1 2 3 4 5 4 3 2 1
            즉 어떤수의 제곱 -> 어떤수의제곱+어떤수 -> (어떤수+1) 제곱 순

        */

        
        int doubleNum = (int) sqrt(distance); // 제곱수
        // 원래는 2부터 시작하여 반복문을 썼는데 시간초과로 인해서
        // sqrt를 이용하여 빠르게 제곱수를 찾는다.

        int opNum = doubleNum * 2 - 1; // 작동 횟수


        // 1 2 3 예외처리
        if (distance <= 3) {
            cout << distance << "\n";
            continue;
        }

        
        if (doubleNum * doubleNum >= distance) {
            cout << opNum << "\n";
            continue;
        }

        opNum++; // 작동 횟수 증가

        if (doubleNum * doubleNum + doubleNum >= distance) {
            cout << opNum << "\n";
            continue;
        }
        else {
            cout << opNum + 1 << "\n";
            continue;
        }
    }

    return 0;
}
