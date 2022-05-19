/*
	https://www.acmicpc.net/problem/5086

	배수 약수

*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	while (1) {
		cin >> N >> M;
		if (N == 0 && M == 0) break;
		else if (N != 0 && M % N == 0) cout << "factor\n";
		else if (M != 0 && N % M == 0) cout << "multiple\n";
		else cout << "neither\n";
	}
	
	return 0;
}