// https://www.acmicpc.net/problem/2914

/*
	두번째 입력값을 1 빼고
	첫번째 입력값과 곱한 후 1을 더하면 된다.
*/

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int A, i;
	cin >> A >> i;

	cout << A * (i - 1) + 1;

	return 0;
}