#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int ans = 0, num, temp;
	cin >> num;
	for (int i = 0; i < 4; i++) {
		cin >> temp;
		if (abs(num - temp) <= 1000) ans++;
	}
	cout << ans;
	return 0;
}