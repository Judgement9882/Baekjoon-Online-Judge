// https://www.acmicpc.net/problem/11050

#include <bits/stdc++.h>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K;
	cin >> N >> K;
	
	int ans = 1;
	for (int i = 0; i < K; i++) ans *= N--;
	for (int i = 1; i <= K; i++) ans /= i;
	cout << ans;
	return 0;
}