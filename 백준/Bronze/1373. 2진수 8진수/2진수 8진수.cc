#include <iostream>
#include <vector>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string num; cin >> num;
	int len = num.length();
	vector<int> eight;
	for (int i = len - 1; i >= 0; i -= 3) {
		int temp = 0;
		temp += (num[i] - '0');
		if (i - 1 >= 0) temp += (num[i - 1] - '0') * 2;
		if (i - 2 >= 0) temp += (num[i - 2] - '0') * 4;
		eight.push_back(temp);
	}
	for (int i = eight.size() - 1; i >= 0; i--) {
		cout << eight[i];
	}
	return 0;
}