/*
	https://www.acmicpc.net/problem/25372

	비밀번호 자리수
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T; cin >> T;
	while (T--) {
		string pw;
		cin >> pw;
		if (pw.length() < 6 || pw.length() > 9) cout << "no\n";
		else cout << "yes\n";
	}
	return 0;
}