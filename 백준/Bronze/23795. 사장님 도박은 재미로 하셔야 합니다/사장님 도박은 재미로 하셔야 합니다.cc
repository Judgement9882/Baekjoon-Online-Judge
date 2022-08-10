/*
	https://www.acmicpc.net/problem/23795

	재미도박
*/

#include <iostream>
using namespace std;
int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int cnt = 0, num;
	while (1) {
		cin >> num;
		if (num == -1) break;
		cnt += num;
	}
	cout << cnt;
	return 0;
}



