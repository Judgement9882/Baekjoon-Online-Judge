/*
	https://www.acmicpc.net/problem/10569

	다면체
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, V, E;
	cin >> T;
	while (T--) {
		cin >> V >> E;
		cout << 2 - V + E << "\n";
	}

	return 0;
}