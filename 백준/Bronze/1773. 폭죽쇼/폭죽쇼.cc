/*
	https://www.acmicpc.net/problem/1773

	폭죽쇼
*/

#include <iostream>

using namespace std;

bool pok[2000002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, C, num;
	cin >> N >> C;
	while (N--) {
		cin >> num;
		for (int i = num; i <= C; i += num) pok[i] = 1;
	}

	int cnt = 0;
	for (int i = 1; i <= C; i++) {
		if (pok[i] == 1) cnt++;
	}
	cout << cnt;

	return 0;
}



