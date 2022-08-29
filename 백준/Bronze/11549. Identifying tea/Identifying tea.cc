/*
	https://www.acmicpc.net/problem/11549

	Identifying tea
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T; cin >> T;
	int n = 5, cnt = 0;
	while (n--) {
		int temp; cin >> temp;
		if (T == temp) cnt++;
	}
	cout << cnt;
	return 0;
}