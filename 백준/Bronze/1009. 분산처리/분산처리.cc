/*
	https://www.acmicpc.net/problem/1009

	a^b 1의자리 구하기


	a=XXX2 => 2, 4, 8, 6
	a = XXX3 => 3, 9, 7, 1
	7 => 7 9 3 1
	8 => 8 4 2 6

	4 => 4, 6, 4, 6
	9 => 9 1 9 1



	4개가 나오는 수 2, 3, 7, 8
	2개 나오는 수 : 4, 9
	자기자신이 나오는 수 0, 1, 5, 6
	
	
*/

#include <iostream>

using namespace std;


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;

	while (T--) {
		int a, b;
		cin >> a >> b;

		a %= 10;
		if (a == 0) {
			cout << 10 << "\n";
			continue;
		}
		if (a == 2 || a == 3 || a == 7 || a == 8) {
			if (b % 4 == 2) {
				cout << a * a % 10 << "\n";
				continue;
			}
			else if (b % 4 == 3) {
				cout << a * a * a % 10 << "\n";
				continue;
			}
			else if (b % 4 == 0) {
				cout << a * a * a * a % 10 << "\n";
				continue;
			}
		}
		else if (a == 4 || a == 9) {
			if (b % 2 == 0) {
				cout << a * a % 10 << "\n";
				continue;
			}
		}
		cout << a % 10 << "\n";
	}
	return 0;
}