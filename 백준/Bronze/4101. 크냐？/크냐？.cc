/*
	https://www.acmicpc.net/problem/4101

	크냐?

*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K;
	while (1) {
		cin >> N >> K;
		if (N == 0 && K == 0) return 0;
		if (N > K) cout << "Yes\n";
		else cout << "No\n";
	}
	
	return 0;
}