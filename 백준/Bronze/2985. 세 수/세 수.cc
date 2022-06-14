/*
	https://www.acmicpc.net/problem/2985
	
	세 수
*/

#include <iostream>

using namespace std;

char op = '+';

int cal(int a, int b, int c) {
	if (a + b == c) {
		op = '+';
		return 1;
	}
	else if (a - b == c) {
		op = '-';
		return 1;
	}
	else if (a * b == c) {
		op = '*';
		return 1;
	}
	else if (a % b == 0 && a / b == c) {
		op = '/';
		return 1;
	}
	else return 0;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int a, b, c;
	cin >> a >> b >> c;
	
	if (cal(a, b, c)) cout << a << op << b << '=' << c;
	else if (cal(b, c, a)) cout << a << '=' << b << op << c;
	return 0;
}
