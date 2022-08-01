/*
	https://www.acmicpc.net/problem/1598

	꼬리
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A, B;
	cin >> A >> B;
	A--; B--;
	cout << abs((A % 4) - (B % 4)) + abs(A / 4 - B / 4);



	return 0;
}



