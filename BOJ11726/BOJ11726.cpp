// https://www.acmicpc.net/problem/11726

/*
	dp로 해결.
	
	1. 정의
	D[i] = N이 i 일때 직사각형을 채울 수 있는 방법의 수

	2. 점화식
	-> 첫 열과 두번째 열을 가로방향으로 눕히면
	D[N-2] 경우가 나오고, 첫번째 열을 세로로 고정시키면
	D[N-1] 을 생각한 경우가 나옵니다. 이 두경우를 더하면
	겹치는 경우없이 나옵니다.

	D[N] = D[N-1]+D[N-2]

	3. 초기화
	D[1] = 1
	D[2] = 2
*/

#include <bits/stdc++.h>
using namespace std;

int D[1002];
int N;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	D[1] = 1;
	D[2] = 2;
	if (N <= 2) {
		cout << D[N];
		return 0;
	}

	for (int i = 3; i <= N; i++) {
		D[i] = (D[i - 1] + D[i - 2]) % 10007;
	}
	cout << D[N];
	return 0;
}