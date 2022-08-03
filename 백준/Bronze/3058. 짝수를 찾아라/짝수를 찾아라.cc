/*
	https://www.acmicpc.net/problem/3058

	짝수 찾기
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	while (T--) {
		int cnt = 0;
		int min_val = 9999999;
		int num;
		for (int i = 0; i < 7; i++) {
			cin >> num;
			if (num % 2 == 0) {
				cnt += num;
				min_val = min(min_val, num);
			}
		}
		cout << cnt << " " << min_val << "\n";
	}

	return 0;
}



