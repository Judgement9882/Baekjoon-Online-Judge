// https://www.acmicpc.net/problem/1149

/*
	백트래킹으로 접근하면 3^1000 의 연산을 수행하기에
	dp로 접근합니다.

	1. 식 정의
	D[i][j] = i번째 건물의 색을 j색깔로 칠함.

	2. 점화식
	D[i][j] = min(D[i-1][(j+1)%3], D[i-1][(j+2)%3]) + cost[i][j]

	3. 초기값
	i-1 번째를 계산해야하고 j에 대해 %3을 만족하기위해
	D[1][0], D[1][1], D[1][2]

*/

#include <bits/stdc++.h>

using namespace std;

int N;
int D[1002][3];
int cost[1002][3];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> cost[i][j];
		}
	}

	D[1][0] = cost[1][0];
	D[1][1] = cost[1][1];
	D[1][2] = cost[1][2];

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 3; j++) {
			D[i][j] = min(D[i - 1][(j + 1) % 3], D[i - 1][(j + 2) % 3]) + cost[i][j];
		}
	}
	
	// 방법 1
	// cout << *min_element(D[N], D[N] + 3);

	// 방법 2
	cout << min({ D[N][0], D[N][1], D[N][2] });

	// 방법 3
	//int mn = min(D[N][0], D[N][1]);
	//mn = min(mn, D[N][2]);
	//cout << mn;
	return 0;
}