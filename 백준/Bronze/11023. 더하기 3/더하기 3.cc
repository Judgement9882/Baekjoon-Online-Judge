/*
	https://www.acmicpc.net/problem/11023
	
	더하기3
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);
	int n, cnt = 0;
	
	while (1) {
		cin >> n;
		if (cin.eof() == true) break;
		cnt += n;
	}

	cout << cnt;
	return 0;
}
