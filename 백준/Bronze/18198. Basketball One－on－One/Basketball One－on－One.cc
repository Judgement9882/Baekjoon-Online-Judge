#include <iostream>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	
	string str;
	cin >> str;
	int a = 0, b = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i++] == 'A') a += str[i] - '0';
		else b += str[i] - '0';
	}
	cout << (a > b ? 'A' : 'B');
	return 0;
}