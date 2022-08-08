/*
	https://www.acmicpc.net/problem/25377

	빵
*/

#include <iostream>
#include <algorithm>
using namespace std;
int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	int max_bbang = 999999;
	while (T--) {
		int front, back;
		cin >> front >> back;
		if (front > back) continue;
		else max_bbang = min(max_bbang, back);
	}
	if (max_bbang == 999999) cout << -1;
	else cout << max_bbang;
	return 0;
}



