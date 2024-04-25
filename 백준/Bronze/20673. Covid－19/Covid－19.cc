#include <iostream>
#include <list>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	int p, q;
	cin >> p >> q;
	string ans;
	if (p <= 50 && q <= 10) ans = "White";
	else if (q > 30) ans = "Red";
	else ans = "Yellow";
	cout << ans;
	return 0;
}