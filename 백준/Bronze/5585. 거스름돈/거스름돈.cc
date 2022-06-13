/*
	https://www.acmicpc.net/problem/5717

	거스름돈
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int change[6] = { 500, 100, 50, 10, 5, 1 };
	int money, num = 0, i=0;

	cin >> money;
	money = 1000 - money;
	while (money != 0) {
		if (money >= change[i]) {
			money -= change[i];
			num++;
		}
		else i++;
	}
	cout << num;

	return 0;
}

