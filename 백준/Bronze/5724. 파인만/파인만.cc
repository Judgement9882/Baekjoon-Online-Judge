/*
	https://www.acmicpc.net/problem/5724

	파인만
*/

#include <iostream>

int sqr[102];
using namespace std;
int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	sqr[1] = 1;
	for (int i = 2; i <= 100; i++) {
		sqr[i] = sqr[i - 1] + i * i;
	}


	while (1) {
		int T;
		cin >> T;
		if (T == 0) break;
		cout << sqr[T] << "\n";

	}

	return 0;
}



