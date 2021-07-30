// https://www.acmicpc.net/problem/5596

#include <bits/stdc++.h>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N = 2;
	int mx = -999;
	while (N--) {
		int A, B, C, D;
		cin >> A >> B >> C >> D;
		mx = max(mx, A + B + C + D);
	}
	cout << mx;
	return 0;
}