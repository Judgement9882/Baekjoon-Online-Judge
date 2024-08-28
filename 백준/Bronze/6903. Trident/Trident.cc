#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int t, s, h; cin >> t >> s >> h;
	for (int i = 0; i < t; i++) {
		cout << "*";
		for (int j = 0; j < s; j++) cout << " ";
		cout << "*";
		for (int j = 0; j < s; j++) cout << " ";
		cout << "*\n";
	}

	for (int i = 0; i < 3 + 2 * s; i++) cout << "*";
	cout << '\n';

	for (int i = 0; i < h; i++) {
		for (int i = 0; i < s + 1; i++) cout << " ";
		cout << "*\n";
	}

	return 0;
}