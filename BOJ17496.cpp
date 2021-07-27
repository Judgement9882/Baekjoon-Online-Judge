// https://www.acmicpc.net/problem/17496

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int T, C, N, P;
	cin >> N >> T >> C >> P;
	cout << P * ((N-1) / T) * C;
	return 0;
}