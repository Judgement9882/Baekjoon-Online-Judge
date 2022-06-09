/*
	https://www.acmicpc.net/problem/5717

	상근이친구
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int M, F;
	while (1) {
		cin >> M >> F;
		if (M == 0 && F == 0) break;
		cout << M + F << "\n";
	}


	return 0;
}