/*
	https://www.acmicpc.net/problem/

	삼각수
*/

#include <iostream>

using namespace std;

int Tn[302];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	for (int i = 1; i < 302; i++) Tn[i] = Tn[i - 1] + i;
	
	int T;
	cin >> T;
	while (T--) {
		int n;
		cin >> n;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i * Tn[i + 1];
		}
		cout << sum << "\n";
	}


	return 0;
}



