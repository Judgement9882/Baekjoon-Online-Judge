/*
	https://www.acmicpc.net/problem/2566
	
	9x9 최대값
*/

#include <iostream>

using namespace std;

int main() {

	
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int num, max_num = -999, max_i, max_j;

	for (int i = 1; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			cin >> num;
			if (num > max_num) {
				max_num = num;
				max_i = i;
				max_j = j;
			}
		}
	}

	cout << max_num << "\n" << max_i << " " << max_j;


	return 0;
}
