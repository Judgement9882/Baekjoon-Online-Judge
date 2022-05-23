/*
	https://www.acmicpc.net/problem/2501

	K번째 약수

*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K, cnt=0;
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		if (N % i == 0) {
			cnt++;
		}
		if (K == cnt) {
			cout << i;
			return 0;
		}
	}
	cout << 0;
	return 0;
}