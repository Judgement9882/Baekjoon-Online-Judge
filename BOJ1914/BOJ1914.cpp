#include <iostream>
#include <algorithm>
#include <string>

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

string add(string a, string b) {
    int sum = 0;
    string result;

    while (!a.empty() || !b.empty() || sum) {
        if (!a.empty()) {
            sum += a.back() - '0';
            a.pop_back();
        }
        if (!b.empty()) {
            sum += b.back() - '0';
            b.pop_back();
        }
        result.push_back((sum % 10) + '0');
        sum /= 10;
    }
    reverse(result.begin(), result.end());
    return result;
}

int main() {

    // 입출력 속도 관리
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    cin >> N;

    string k = "1";
    for (int i = 0; i < N; i++) {
        k = add(k, k);
    }
    // 2의 제곱이기 때문에 끝자리수는 2, 4, 8, 6
    // -1을 할 때 십의자리 생각 x
    int last = (k.back() - '0') - 1;
    k.back() = last + '0';
    cout << k << "\n";

    if (N <= 20) {
        Hanoi(1, 3, N);
    }
    return 0;
}