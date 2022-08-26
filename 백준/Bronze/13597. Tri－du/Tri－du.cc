/*
	https://www.acmicpc.net/problem/13597

	Tri-du
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B; cin >> A >> B;
	if (A == B) cout << A;
	else cout << max(A, B);

	return 0;
}



