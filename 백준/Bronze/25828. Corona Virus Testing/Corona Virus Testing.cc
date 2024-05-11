#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int g, p, t;
	cin >> g >> p >> t;
	int one = g * p;
	int two = g + p * t;
	if (one < two) cout << 1;
	else if (one > two) cout << 2;
	else cout << 0;
	return 0;
}