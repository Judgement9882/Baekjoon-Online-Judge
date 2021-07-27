// https://www.acmicpc.net/problem/15964

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	long long A, B;
	cin >> A >> B;
	cout << (A+B) * (A-B);

	return 0;
}