#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int B = 0, C = 0;
	string temp; cin >> temp;
	for (int i = 0; i < temp.length(); i++) {
		if (temp[i] == 'B') B++;
		else C++;
	}
	cout << B / 2 + C / 2;

	return 0;
}