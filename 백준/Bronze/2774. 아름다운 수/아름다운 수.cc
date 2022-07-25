/*
	https://www.acmicpc.net/problem/2774

	아름다운수
*/

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	while (T--){
		int num[10];
		fill(num, num + 10, 0);

		string temp;
		cin >> temp;
		for (int i = 0; i < temp.length(); i++) {
			num[temp[i] - '0'] = 1;
		}
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (num[i] == 1) sum++;
		}
		cout << sum << "\n";
	}

	return 0;
}



