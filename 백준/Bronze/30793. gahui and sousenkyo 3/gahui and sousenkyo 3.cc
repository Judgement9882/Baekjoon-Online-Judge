#include <iostream>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	double px, rx, vx;
	cin >> px >> rx;
	vx = px / rx;
	if (vx < 0.2) cout << "weak";
	else if (vx < 0.4) cout << "normal";
	else if (vx < 0.6) cout << "strong";
	else cout << "very strong";
	
	return 0;
}