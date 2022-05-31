/*
	https://www.acmicpc.net/problem/2010

	플러그
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, temp, cnt = 0;
	cin >> N;
	cnt = cnt - N + 1;
	while (N--) {
		cin >> temp;
		cnt += temp;
	}
	
	cout << cnt;

	return 0;
}