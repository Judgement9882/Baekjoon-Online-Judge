/*
	https://www.acmicpc.net/problem/5717

	그릇
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	char plate = ';';
	int cnt = 0;

	string input;
	cin >> input;
	for (int i = 0; i < input.length(); i++) {
		if (input[i] != plate) {
			cnt += 10;
			plate = input[i];
		}
		else cnt += 5;
	}
	cout << cnt;

	return 0;
}