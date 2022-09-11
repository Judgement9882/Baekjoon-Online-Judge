/*
	https://www.acmicpc.net/problem/24736

	Football Scoring
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N = 2;
	while (N--) {
		int a, b, c, d, e;
		cin >> a >> b >> c >> d >> e;
		cout << a * 6 + b * 3 + c * 2 + d * 1 + e * 2 << "\n";
	}


	return 0;
}
