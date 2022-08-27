/*
	https://www.acmicpc.net/problem/1145

	 대부분의배수
*/

#include <iostream>
#include <algorithm>
using namespace std;

int num[5];

int gcd(int a, int b) {
	int n;
	while (b != 0) {
		n = a % b;
		a = b;
		b = n;
	}

	return a;
}

int lcm(int a, int b) {
	return a * b / gcd(a, b);
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	for (int i = 0; i < 5; i++) cin >> num[i];

	int a = 0, b = 1;
	int lalm = 0x7f7f7f7f;
	while (1) {
		int this_turn_lcm = lcm(num[a], num[b]);
		
		for (int i = 0; i < 5; i++) {
			// 같으면 다른 수 선택
			if (i == a || i == b) continue;

			lalm = min(lalm, lcm(this_turn_lcm, num[i]));
		}

		b++;
		if (b == 5) {
			// 마지막일경우
			if (a == 3) break;
			b = a+2;
			a++;
		}
	}

	cout << lalm;

	return 0;
}