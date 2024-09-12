#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	cout << a+b+c+d - min(a, min(b, min(c, d))) + 1;
	return 0;
}