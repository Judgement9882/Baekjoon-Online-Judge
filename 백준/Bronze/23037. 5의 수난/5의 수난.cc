/*
	https://www.acmicpc.net/problem/23037

	다섯자리수

*/

#include <iostream>
#include <string>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string num;
	int cnt = 0, temp;
	cin >> num;
	for (int i = 0; i < 5; i++) {
		temp = 1;
		for (int j = 1; j <= 5; j++) {
			temp *= int(num[i] - '0');
		}
		cnt += temp;
	}
	cout << cnt;



	return 0;
}