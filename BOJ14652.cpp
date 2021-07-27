// https://www.acmicpc.net/problem/14652

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	long long N, M, K;
	cin >> N >> M >> K;
	cout << K / M << " " << K % M;

	return 0;
}