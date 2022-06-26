/*
	https://www.acmicpc.net/problem/16673

	와인
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	long long C, K, P, cnt = 0;
	cin >> C >> K >> P;
	for (int i = 1; i <= C; i++) {
		cnt += K * i + P * i * i;
	}
	cout << cnt;
	return 0;
}