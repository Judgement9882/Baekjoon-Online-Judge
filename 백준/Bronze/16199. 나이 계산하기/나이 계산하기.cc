/*
	https://www.acmicpc.net/problem/16199

	나이계산
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B, C; cin >> A >> B >> C; // 생년월일
	int D, E, F; cin >> D >> E >> F; // 기준
	
	int cal = E * 31 + F - (B * 31 + C);
	if (cal < 0) cout << D - A - 1 << "\n";
	else cout << D - A << "\n";

	// 세는 나이
	cout << D - A + 1 << "\n";

	// 연 나이
	cout << D - A;


	return 0;
}
