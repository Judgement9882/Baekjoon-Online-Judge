/*
	https://www.acmicpc.net/problem/14501

	퇴사
*/

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;


int max_val[21];
int N;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		int T, P; cin >> T >> P;
		
		// 다음날 급여가 오늘 급여보다 작으면 오늘 급여를 쓴다.
		if (max_val[i] > max_val[i + 1]) {
			max_val[i + 1] = max_val[i];
		}

		// 일한만큼의 급여가 T를 더한것보다 더 크다면
		if (max_val[i] + P > max_val[i + T]) {
			max_val[i + T] = max_val[i] + P;
		}
		
	}

	cout << max_val[N];



	return 0;
}
