/*
	https://www.acmicpc.net/problem/17009

	Winning score
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A_sum = 0, B_sum = 0;
	
	for(int i = 3 ; i > 0; i--) {
		int A; cin >> A;
		A_sum += A*i;
	}
	for (int i = 3; i > 0; i--) {
		int B; cin >> B;
		B_sum += B*i;
	}

	if (A_sum > B_sum) cout << "A";
	else if (A_sum == B_sum) cout << "T";
	else cout << "B";
	return 0;
}