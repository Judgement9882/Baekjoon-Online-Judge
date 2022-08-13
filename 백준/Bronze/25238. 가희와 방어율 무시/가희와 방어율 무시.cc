/*
	https://www.acmicpc.net/problem/25238

	방무
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	bool candamage = 1;

	double defence, d_break;
	cin >> defence >> d_break;
	if (defence - defence * (d_break / 100) >= 100) candamage = 0;
	cout << candamage;
	
	return 0;
}