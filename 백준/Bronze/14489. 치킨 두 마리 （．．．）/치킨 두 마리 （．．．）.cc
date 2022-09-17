/*
	https://www.acmicpc.net/problem/14489

	치킨 두 마리
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B; cin >> A >> B;
	int C; cin >> C;
	if (A + B >= 2*C) cout << A + B - 2*C;
	else cout << A + B ;
	



	return 0;
}
