/*
	https://www.acmicpc.net/problem/16693

	
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	double a, b, p, q;
	cin >> a >> b >> p >> q;
	p = 3.14159265359 *p*p;

	if (a / b > p / q) {
		cout << "Slice of pizza";
	}
	else {
		cout << "Whole pizza";
	}

	return 0;
}
