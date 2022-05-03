/*
	https://www.acmicpc.net/problem/13458

	총감독관 부감독관
*/

#include <iostream>
#include <vector>
using namespace std;

vector<int> A;
long long cnt = 0;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	int T = N;
	while (T--) {
		int temp;
		cin >> temp;
		A.push_back(temp);
	}
	
	int B, C;
	cin >> B >> C;
	

	for (int i = 0; i < N; i++) {
		// 최소 한명은 들어가 있으므로 cnt + 1
		cnt++;

		// 총 감독관 한 명으로 충분한 경우
		if (A[i] - B <= 0) continue;

		// 나누어 떨어지면 몫 만 더하면 됨
		if ((A[i] - B) % C == 0) {
			cnt += (A[i] - B) / C;
			continue;
		}
		// 아닐 경우 부감독관 한명 더 필요
		else {
			cnt += ((A[i] - B) / C) + 1;
		}
	}

	cout << cnt;

	return 0;
}