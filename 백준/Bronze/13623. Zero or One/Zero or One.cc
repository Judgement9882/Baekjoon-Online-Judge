/*
	https://www.acmicpc.net/problem/13623

	zero or one
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int A, B, C; cin >> A >> B >> C;
	if (A == B && B != C) cout << "C";
	else if (A == C && A != B) cout << "B";
	else if (B == C && A != B) cout << "A";
	else cout << "*";

	return 0;
}
