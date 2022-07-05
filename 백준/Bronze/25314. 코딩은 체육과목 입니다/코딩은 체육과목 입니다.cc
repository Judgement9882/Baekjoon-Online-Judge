/*
	https://www.acmicpc.net/problem/25314

	롱롱롱
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N;
	cin >> N;
	while (N >= 0) {
		if (N >= 4) cout << "long ";
		else cout << "int";
		N -= 4;
	}

	return 0;
}