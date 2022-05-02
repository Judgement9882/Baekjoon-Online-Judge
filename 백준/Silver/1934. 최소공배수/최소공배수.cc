/*
	https://www.acmicpc.net/problem/1934

	최소공배수 구하기
*/

#include <iostream>

using namespace std;

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

	int T;
	cin >> T;

	while (T--) {
		int A, B;
		cin >> A >> B;
		cout << lcm(A, B) << "\n";

	}
	
	return 0;
}