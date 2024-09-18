#include <iostream>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int a, w, v;
	cin >> a >> w >> v;
	if (w >= a * v) cout << 1;
	else cout << 0;
	return 0;
}