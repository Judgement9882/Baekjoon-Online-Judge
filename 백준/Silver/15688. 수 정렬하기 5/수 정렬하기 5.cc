/*
	https://www.acmicpc.net/problem/15688

	정렬 5
*/

#include <iostream>
#include <algorithm>

using namespace std;

int num[1000002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T; cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> num[i];
	}
	sort(num, num + T);

	for (int i = 0; i < T; i++) {
		cout << num[i] << "\n";
	}

	return 0;
}
