/*
	https://www.acmicpc.net/problem/1977

	완전제곱수
*/

#include <iostream>
#include <cmath>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int M, N, min_com=0;
	long long cnt = 0;
	cin >> M >> N;
	for (int i = M; i <= N; i++) {
		if (int(sqrt(i)) > int(sqrt(i - 1))) {
			cnt += i;
			if (min_com == 0) min_com = i;
		}
	}
	if (cnt == 0) cout << -1;
	else cout << cnt << "\n" << min_com;
	return 0;
}