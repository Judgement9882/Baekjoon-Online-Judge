/*
	https://www.acmicpc.net/problem/1076

	쌍의 합
*/

#include <iostream>
#include <vector>

using namespace std;
int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;

	vector<pair<int, int>> ssang;
	while (T--) {
		while (!ssang.empty()) ssang.pop_back();

		int n;
		cin >> n;
		cout << "Pairs for " << n << ": ";

		// 2 이하면 쌍이 없음.
		if (n <= 2) {
			cout << "\n";
			continue;
		}

		for (int i = 1; i <= n / 2; i++) {
			if (i == n - i) continue;
			ssang.push_back({ i, n - i });
		}
		for (int i = 0; i < ssang.size(); i++) {
			cout << ssang[i].first << " " << ssang[i].second;
			if (i + 1 != ssang.size()) cout << ", ";
		}
		cout << "\n";
	}

	return 0;
}



