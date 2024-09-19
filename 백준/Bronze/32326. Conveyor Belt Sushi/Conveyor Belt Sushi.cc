#include <iostream>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int R, G, B;
	cin >> R >> G >> B;
	cout << R * 3 + G * 4 + B * 5;
	return 0;
}