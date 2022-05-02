/*
	https://www.acmicpc.net/problem/1037

	최대 최소 저장
*/

#include <iostream>
#include <string>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int maxNum = 0;
	int minNum = 1000000;

	int T;
	cin >> T;

	while (T--) {
		int n;
		cin >> n;
		if (maxNum <= n) maxNum = n;
		if (minNum >= n) minNum = n;
	}
	
	cout << maxNum * minNum;

	return 0;
}