#include <iostream>

using namespace std;

int Hanoi(int from, int to, int n) // from�� ��տ��� to�� ������� n���� ������ �̵�.
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

    // ����� �ӵ� ����
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    int k = (1 << N) - 1;
    cout << k << "\n";

    Hanoi(1, 3, N);

    return 0;
}