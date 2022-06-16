/*
	https://www.acmicpc.net/problem/6359
	
	만취 상범

	n=5

		ㅁ	ㅁ	ㅁ	ㅁ	ㅁ
	1	o	o	o	o	o
	2	o	x	o	x	o
	3	o	x	x	x	o
	4	o	x	x	o	o
	5	o	x	x	o	x
*/

#include <iostream>

using namespace std;

bool jail[102];

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int T, n, cnt;
	cin >> T;
	while (T--) {
		fill(jail, jail+102, 0);

		cin >> n;
		cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j+=i) {
				jail[j] ^= 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (jail[i] == 1) cnt++;
		}
		cout << cnt << "\n";
	}

	return 0;
}
