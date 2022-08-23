/*
	https://www.acmicpc.net/problem/25304

	영수증
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int X; cin >> X;
	int N; cin >> N;
	
	while (N--) {
		int a, b; cin >> a >> b;
		X -= a * b;
	}
	if (X == 0) cout << "Yes";
	else cout << "No";
	
	return 0;
}