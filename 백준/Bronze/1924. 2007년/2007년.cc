/*
    https://www.acmicpc.net/problem/1924

    2007년
*/


#include <iostream>

using namespace std;

int main() {

    cin.tie(0);
    ios::sync_with_stdio(0);

    int x, y; cin >> x >> y;

    int month[12] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };

    int sum = 0;
    for (int i = 1; i < x; i++) {
        sum += month[i];
    }
    sum += y;

    int value = sum % 7;

    switch (value)
    {
    case 0: cout << "SUN";
        break;
    case 1: cout << "MON";
        break;
    case 2: cout << "TUE";
        break;
    case 3: cout << "WED";
        break;
    case 4: cout << "THU";
        break;
    case 5: cout << "FRI";
        break;
    case 6: cout << "SAT";
        break;
    }
    return 0;
}
