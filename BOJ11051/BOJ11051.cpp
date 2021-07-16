// https://www.acmicpc.net/problem/11051

#include <bits/stdc++.h>

using namespace std;


int D[1002][1002];

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int N, K;
	cin >> N >> K;


	// D[i][j] = iCj
	// iCj = i-1Cj-1 + i-1Cj
	// D[i][j] = D[i-1][j-1] + D[i-1][j]

	for (int i = 1; i <= N; i++) {
		D[i][0] = D[i][i] = 1;

		for (int j = 1; j < i; j++) {
			D[i][j] = (D[i - 1][j - 1] + D[i - 1][j]) % 10007;
		}
	}

	cout << D[N][K];
	return 0;
}