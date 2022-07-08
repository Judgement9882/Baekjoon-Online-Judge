/*
	https://www.acmicpc.net/problem/5988

	홀짝
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	while (N--) {
		string K;
		cin >> K;
		if ((K[K.length()-1] - '0') % 2 == 0) cout << "even\n";
		else cout << "odd\n";
	}

	return 0;
}