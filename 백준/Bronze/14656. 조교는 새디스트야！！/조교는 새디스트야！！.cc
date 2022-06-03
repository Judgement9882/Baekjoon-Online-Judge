/*
	https://www.acmicpc.net/problem/14656

	줄빠따
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, num, cnt = 0;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> num;
		if (num != i) cnt++;
	}
	cout << cnt;

	return 0;
}