/*
	https://www.acmicpc.net/problem/1699

	최소 제곱수의 합


	1 = 1 => 1
	2 = 1+1 => 2
	3 = 1+1+1 => 3

	4 = 4 => 1
	5 = 4+1(1) => 2
	6 = 4+1+1(2) => 3
	7 = 4+1+1+1(3) => 4

	8 = 4+4(4) => 2
	9 = 4+4+1(5) => 3
	10 = 4+4+1+1(6) => 4
	11 = 4+4+1+1+1(7) => 5

	12 = 4+4+4(8) => 3
	...

	16 = 16 => 1
	17 = 16 + 1(1) => 2
	...

	해당 수를 넘지않거나 같은 제곱수를 빼고 1로 표현할 수 있는 수와 비교하여 최솟값 선택

*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[100002];


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		dp[i] = i;
	}

	for (int i = 4; i <= N; i++) {
		for (int j = 2; j * j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}

	cout << dp[N];

	return 0;
}