#include <iostream>

using namespace std;

int Hanoi(int from, int to, int n) // from번 기둥에서 to번 기둥으로 n개의 원반을 이동.
{
    if (n == 1)
    {
        cout << from << " " << to << "\n";
        return 0;
    }

    Hanoi(from, 6 - from - to, n - 1);
    cout << from << " " << to << "\n";
    Hanoi(6 - from - to, to, n - 1);
    return 0;
}


int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    int k = (1 << N) - 1;
    cout << k << "\n";

    Hanoi(1, 3, N);

    return 0;
}