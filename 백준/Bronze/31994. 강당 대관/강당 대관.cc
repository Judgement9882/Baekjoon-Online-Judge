#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int seven = 7;
	int total = 0; string ans;
	while (seven--) {
		string temp; int num;
		cin >> temp >> num;
		if (total < num) {
			total = num;
			ans = temp;
		}
	}
	cout << ans;
	return 0;
}