#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int T, n, num; cin >> T;
	while (T--) {
		cin >> n;
		double sum = 0.0;
		double max_num = 0, min_num = 0x7f7f7f7f;
		for (int i = 0; i < n; i++) {
;			cin >> num;
			sum += num;
			if (max_num < num) max_num = num;
			if (min_num > num) min_num = num;
		}
		sum /= n;
		if (abs((max_num + min_num) / 2 - sum) <= 1.0) cout << "Yes" << "\n";
		else cout << "No" << "\n";
	}
	return 0;
}