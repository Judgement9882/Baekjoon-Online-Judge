/*
	https://www.acmicpc.net/problem/17009

	Winning score
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	cout << "Gnomes:\n";
	while (N--) {
		int A, B, C; cin >> A >> B >> C;
		if (A < B && B < C) cout << "Ordered\n";
		else if (A > B && B > C) cout << "Ordered\n";
		else cout << "Unordered\n";
	}
	return 0;
}