/*
	https://www.acmicpc.net/problem/11179

	2진수뒤집기
*/

#include <iostream>
using namespace std;

int bin[34];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	int idx = 0;
	while (1) {
		bin[idx] = N & 0x1; // 1과 AND 연산
		N >>= 1;
		if (N == 0) break;
		idx++;
	}
	int mul = 1, num = 0;
	for (int i = idx; i >= 0; i--) {
		num += bin[i] * mul;
		mul <<= 1;
	}
	cout << num;
	
	
	
	return 0;
}