#include <iostream>
#include <string>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string N; cin >> N;
	bool ans = false;
	if (N.length() >= 2) {
		for (int m = 0; m < N.length(); m++) {
			int front = 1;
			for (int s = 0; s <= m; s++) {
				front *= N[s] - '0';
			}

			int back = 1;
			for (int e = m + 1; e < N.length(); e++) {
				back *= N[e] - '0';
			}

			if (front == back) {
				ans = true;
				break;
			}
		}
	}
	cout << (ans ? "YES" : "NO");
	return 0;
}