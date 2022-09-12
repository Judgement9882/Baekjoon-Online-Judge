/*
	https://www.acmicpc.net/problem/4892

	숫자 맞추기 게임
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	int T = 1;
	while (1) {
		
		int N; cin >> N;
		if (N == 0) break;
		cout << T++ << ".";
		N *= 3;
		// 짝수
		if (N % 2 == 0) cout << " even " << N/6 << "\n";
		else cout << " odd " << (N/3 - 1) / 2 << "\n";
		


	}


	return 0;
}
