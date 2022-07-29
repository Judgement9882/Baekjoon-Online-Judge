/*
	https://www.acmicpc.net/problem/1076

	저항
*/

#include <iostream>

using namespace std;

int colorValue(string color) {
	if (color == "black") return 0;
	else if (color == "brown") return 1;
	else if (color == "red") return 2;
	else if (color == "orange") return 3;
	else if (color == "yellow") return 4;
	else if (color == "green") return 5;
	else if (color == "blue") return 6;
	else if (color == "violet") return 7;
	else if (color == "grey") return 8;
	else if (color == "white") return 9;
}

int colorMul(string color) {
	if (color == "black") return 1;
	else if (color == "brown") return 10;
	else if (color == "red") return 100;
	else if (color == "orange") return 1000;
	else if (color == "yellow") return 10000;
	else if (color == "green") return 100000;
	else if (color == "blue") return 1000000;
	else if (color == "violet") return 10000000;
	else if (color == "grey") return 100000000;
	else if (color == "white") return 1000000000;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string color;
	cin >> color;
	long long num = 0;
	num += 10 * colorValue(color);
	cin >> color;
	num += colorValue(color);
	cin >> color;
	num *= colorMul(color);
	cout << num;
	return 0;
}



