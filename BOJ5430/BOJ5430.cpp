#include <bits/stdc++.h>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, n;
	cin >> T;

	for (int i = 0; i < T; i++) {
		deque<int> num;
		string p, x;
		cin >> p >> n >> x;
		
		int temp = 0;
		for (int j = 0; j < x.length(); j++) {
			if (x[j] == ',') {
				num.push_back(temp);
				temp = 0;
			}
			else if (x[j] - '0' >= 0 && x[j] - '0' <= 9) {
				if (temp == 0) {
					temp = x[j] - '0';
				}
				else {
					temp = 10 * temp + (x[j] - '0');
				}
			}
			if (x[j] == ']' && temp != 0) {
				num.push_back(temp);
				temp = 0;
			}
		}

		int flag = 0;
		int reverseflag = 0;

		for(int j = 0 ; j < p.size(); j++) {
			if (p[j] == 'R') {
				reverseflag ^= 1;
			}
			else if (p[j] == 'D') {
				if (num.empty()) {
					flag = 1;
					break;
				}
				else {
					if (reverseflag) {
						num.pop_back();
					}
					else {
						num.pop_front();
					}
				}
			}
		}

		if (flag) {
			cout << "error" << "\n";
		}
		else {
			cout << "[";

			// forward
			if (reverseflag == 0) {
				if (!num.empty()) {
					cout << num.front();
					num.pop_front();
				}
				while (!num.empty()) {
					cout << ",";
					cout << num.front();
					num.pop_front();
				}
			}

			// reverse
			else if (reverseflag) {
				if (!num.empty()) {
					cout << num.back();
					num.pop_back();
				}
				while (!num.empty()) {
					cout << ",";
					cout << num.back();
					num.pop_back();
				}
			}
			cout << "]" << "\n";
		}
	}
	return 0;
}