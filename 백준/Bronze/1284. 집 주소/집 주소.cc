/*
	https://www.acmicpc.net/problem/1284

	집 주소
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string addr;
	while (1) {
		cin >> addr;
		if (addr == "0") break;
		int cnt = 0;
		for (int i = 0; i < addr.length(); i++) {
			if (addr[i] == '1') {
				cnt += 2;
			}
			else if (addr[i] == '0') {
				cnt += 4;
			}
			else {
				cnt += 3;
			}
		}
		cnt += addr.length() + 1;
		cout << cnt << "\n";
	}
	


	return 0;
}