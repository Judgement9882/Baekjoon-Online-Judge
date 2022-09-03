/*
	https://www.acmicpc.net/problem/15000

	CAPS
*/

#include <iostream>
#include <string>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp; cin >> temp;
	for (int i = 0; i < temp.length(); i++) {
		cout << char(temp[i] - 32);
	}
	

	return 0;
}