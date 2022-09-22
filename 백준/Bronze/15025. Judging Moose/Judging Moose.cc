/*
	https://www.acmicpc.net/problem/15025

	Judging Moose
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int l, r;
	cin >> l >> r;
	if (l == r && l == 0) cout << "Not a moose";
	else if (l == r) cout << "Even " << l + r;
	else cout << "Odd " << 2 * max(l, r);


	return 0;
}
