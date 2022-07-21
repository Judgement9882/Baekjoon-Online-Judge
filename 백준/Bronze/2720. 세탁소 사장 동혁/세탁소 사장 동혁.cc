/*
	https://www.acmicpc.net/problem/2720

	세탁소 사장 동혁
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	while (T--) {
		int money;
		int Q = 0, D = 0, N = 0, P = 0;
		cin >> money;
		if (money >= 25) {
			Q = money / 25;
			money -= Q * 25;
		}
		if (money >= 10) {
			D = money / 10;
			money -= D * 10;
		}
		if (money >= 5) {
			N = money / 5;
			money -= N * 5;
		}
		if (money >= 1) {
			P = money;
		}

		cout << Q << " " << D << " " << N << " " << P << "\n";
	}

	return 0;
}



