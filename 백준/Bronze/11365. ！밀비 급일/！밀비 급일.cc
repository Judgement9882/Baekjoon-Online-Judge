/*
	https://www.acmicpc.net/problem/11365

	!밀비 급일
*/

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	string temp;
	while (1) {
		getline(cin, temp);

		if (temp == "END") break;

		reverse(temp.begin(), temp.end());
		cout << temp;
		cout << "\n";
	}


	return 0;
}



