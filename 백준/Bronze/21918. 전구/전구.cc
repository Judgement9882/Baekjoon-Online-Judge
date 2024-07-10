#include <iostream>
#include <vector>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M, s, a, b, c; cin >> N >> M;
	vector<bool> bulb;
	for (int i = 0; i < N; i++) {
		cin >> s;
		if (s == 1) bulb.push_back(true);
		else bulb.push_back(false);
	}
	while (M--) {
		cin >> a >> b >> c;
		if (a == 1) {
			if (c == 1) bulb[b - 1] = true;
			else bulb[b - 1] = false;
		}
		else if (a == 2) {
			for (int i = b; i <= c; i++) {
				bulb[i - 1] = bulb[i - 1] ^ true;
			}
		}
		else if (a == 3) {
			for (int i = b; i <= c; i++) {
				bulb[i - 1] = false;
			}
		}
		else if (a == 4) {
			for (int i = b; i <= c; i++) {
				bulb[i - 1] = true;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		cout << bulb[i] << " ";
	}

	return 0;
}