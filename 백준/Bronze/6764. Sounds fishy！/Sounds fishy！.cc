/*
	https://www.acmicpc.net/problem/6764

	Sounds fishy!
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B, C, D; cin >> A >> B >> C >> D;
	if (A > B && B > C && C > D) { // 감소
		cout << "Fish Diving";
	}
	else if (A == B && B == C && C == D) {
		cout << "Fish At Constant Depth";
	}
	else if (A < B && B < C && C < D) {
		cout << "Fish Rising";
	}
	else cout << "No Fish";
	

	return 0;
}