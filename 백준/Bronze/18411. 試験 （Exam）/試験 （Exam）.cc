/*
	https://www.acmicpc.net/problem/18411

	높은값
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B, C; cin >> A >> B >> C;
	cout << A + B + C - min(min(A, B), C);


	return 0;
}
