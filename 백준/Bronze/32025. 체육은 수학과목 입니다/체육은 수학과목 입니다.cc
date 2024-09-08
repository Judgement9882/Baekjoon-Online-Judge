#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(0); ios::sync_with_stdio(0);
	double H, W; cin >> H >> W;
	cout << min(H, W)/2 * 100;
	return 0;
}