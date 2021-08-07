// https://www.acmicpc.net/problem/5532

#include <bits/stdc++.h>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int L;
	double A, B, C, D;
	cin >> L >> A >> B >> C >> D;

	cout << L - max(ceil(A / C), ceil(B / D) );


	
	return 0;
}