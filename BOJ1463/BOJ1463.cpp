// https://www.acmicpc.net/problem/1463

/*
	- basic idea
	: 할 수 있는 연산의 개수는 3가지 밖에 없고
	각각의 연산 결과의 카운터값중 가장 작은값을
	출력하면 됩니다. 
	
	-> but 시간초과, 접근방식도 백트래킹이 아니라
	bfs로 접근.
	
	- reference idea
	: dp로 접근.
	1. 테이블 정의하기
	: D[i] = i 를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값
	2. 점화식 찾기.
	: D[k] = ?
	D[k] = D[k/3] + 1
	D[k] = D[k/2] + 1
	D[k] = D[k-1] + 1
	-> min(D[k/1] + 1 , D[k/2] + 1, D[k-1] + 1)

	3. 초기값 정의하기
	D[1] = 0


*/

// 처음생각
//#include <bits/stdc++.h>
//
//using namespace std;
//
//int N;
//int mv = 999;
//
//void func(int n, int cnt) {
//	
//	if (n == 1) {
//		mv = min(mv, cnt);
//		return;
//	}
//	if (n % 3 == 0) {
//		func(n / 3, cnt + 1);
//	}
//	else if (n % 2 == 0) {
//		func(n / 2, cnt + 1);
//	}
//	
//	func(n - 1, cnt + 1);
//	
//}
//
//int main() {
//	
//	cin >> N;
//
//	func(N, 0);
//	cout << mv;
//	return 0;
//}


#include <bits/stdc++.h>
using namespace std;

int d[1000005];
int n;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	d[1] = 0; // 3. 초기값 설정
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0) {
			d[i] = min(d[i], d[i / 2] + 1);
		}
		if (i % 3 == 0) {
			d[i] = min(d[i], d[i / 3] + 1);
		}
	}
	cout << d[n];


	return 0;
}