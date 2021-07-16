// https://www.acmicpc.net/problem/2579
/*
	- basic idea : dp
	
	1. 개념 설정하기
	d[i][j] = 현재까지 j개의 계단을 연속해서 밟고
	i번째 계단까지 올라섰을 때 점수 합의 최댓값
	(단 i 번째 계단은 반드시 밟아야함.
	-> j는 1아니면 2일수밖에 없음.)

	2. 점화식
	d[k][1] : 현재 1개의 계단을 연속해서 밟고있고, k번째 계단에 올라와있음.
	-> k-1은 밟지않음 -> 이전의 최대값은 d[k-2][1] or d[k-2][2] 에 저장되어있음
	----> d[k][1] = max(d[k-2][1], d[k-2][2]) + S[k] 
	여기서 S[k]는 k번째 계단의 값.

	d[k][2] : 현재 2번째 계단을 연속해서 밟고있음.
	따라서 이전의 최대값은 d[k-1][1] 에 저장되어있음.
	(d[k-1][2] 는 안됨. 세번연속 밟을수없음)
	따라서 d[k][2] = d[k-1][1] + S[k]

	이후 max(d[n][1], d[n][2]) 출력

	3. 초기값
	d[1][1]
	d[1][2]
	d[2][1]
	d[2][2]

*/

// 이차원 배열 이용
//#include <bits/stdc++.h>
//
//using namespace std;
//
//int point[302];
//int d[305][3];
//int N;
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	cin >> N;
//
//	for (int i = 1; i <= N; i++) {
//		cin >> point[i];
//	}
//	if (N == 1) {
//		cout << point[1];
//		return 0;
//	}
//
//	d[1][1] = point[1];
//	d[1][2] = 0;
//	d[2][1] = point[2];
//	d[2][2] = point[1] + point[2];
//
//	for (int i = 3; i <= N; i++){
//		d[i][1] = max(d[i - 2][1], d[i - 2][2]) + point[i];
//		d[i][2] = d[i - 1][1] + point[i];
//	}
//
//	cout << max(d[N][1], d[N][2]);
//
//	return 0;
//}

/*
	1. D정의
	D[i] : i번째 계단에서의 밟지않은 계단 합의 최솟값.
	단 i번째는 밟지않음.
	
	2. 점화식
	D[i] = min(D[i-2], D[i-3]) + S[i]

	3. 초기값
	D[1], D[2], D[3] 

*/


#include <bits/stdc++.h>

using namespace std;

int point[305];
int d[305];
int N;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	int total_sum = 0;
	for (int i = 1; i <= N; i++) {
		cin >> point[i];
		total_sum += point[i];
	}

	if (N <= 2) {
		cout << total_sum;
		return 0;
	}
	
	d[1] = point[1];
	d[2] = point[2];
	d[3] = point[3];
	for (int i = 4; i <= N; i++) {
		d[i] = min(d[i - 2], d[i - 3]) + point[i];
	}
	cout << total_sum - min(d[N - 1], d[N - 2]);

	return 0;
}