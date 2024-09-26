#include <bits/stdc++.h>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int scoreA = 0, scoreB = 0, num;
	for (int i = 1; i <= 3; i++) {
		cin >> num;
		scoreA += num * i;
	}
	for (int i = 1; i <= 3; i++) {
		cin >> num;
		scoreB += num * i;
	}
	if (scoreA > scoreB) cout << 1;
	else if (scoreA < scoreB) cout << 2;
	else cout << 0;

	return 0;
}