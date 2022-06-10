/*
	https://www.acmicpc.net/problem/9325
	
	돈 계산
*/

#include <iostream>

using namespace std;

int main() {

	
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int T, s, n, q, p;
	cin >> T;
	while (T--) {
		cin >> s; // 가격
		cin >> n; // 옵션
		while (n--) {
			cin >> q >> p; // q : 옵션 개수, p : 옵션 가격
			s += q * p;
		}
		cout << s << "\n";
	}


	return 0;
}
