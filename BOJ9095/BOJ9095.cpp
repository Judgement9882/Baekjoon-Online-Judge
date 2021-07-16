// https://www.acmicpc.net/problem/9095

/*
	- basic idea

	dp를 이용하여 풀기.
	1. 테이블 정의하기
	d[i] = i 를 1,2,3의 합으로 나타낼수 있는 방법

	2. 점화식
	d[2] = 2 // 1+1, 2
	d[3] = 4 // 1+1+1, 1+2, 2+1, 3
	d[4] = 1+1+1+1 1+2+1 2+1+1 3+1 (3을 123 합으로 나타내는방법 + 1)
			1+1+2 2+2 (2를 1,2,3 합으로 나타내는방법 + 2)
			1+3 ( 1을 1 2 3 합으로 나타내는 방법 + 3)

	즉 d[n] = d[n-1]+d[n-2]+d[n-3]
	3. 초기값
	d[1] = 1
	d[2] = 2
	d[3] = 4

*/

#include <bits/stdc++.h>
using namespace std;

int T, N;
int d[15];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> T;
	
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 4; i <= 11; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
	}
	while(T--){
		cin >> N;
		cout << d[N] << "\n";
	}

	return 0;
}