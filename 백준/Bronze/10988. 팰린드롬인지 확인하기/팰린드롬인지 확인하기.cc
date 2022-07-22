/*
	https://www.acmicpc.net/problem/10988

	펠린드롬
*/

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp;
	cin >> temp;
	string temp2 = temp;
	reverse(temp2.begin(), temp2.end());
	if (temp2 == temp) cout << "1";
	else cout << "0";

	return 0;
}



