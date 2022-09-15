/*
	https://www.acmicpc.net/problem/6810

	ISBN
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int A, B, C; cin >> A >> B >> C;
	cout << "The 1-3-sum is " << 91 + A * 1 + B * 3 + C * 1;

	return 0;
}
