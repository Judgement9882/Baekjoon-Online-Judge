/*
	https://www.acmicpc.net/problem/1100

	체스
*/

#include <iostream>
#include <string>
using namespace std;

string temp;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int num_odd[4] = { 1, 3, 5, 7 };
	int num_even[4] = { 0, 2, 4, 6 };

	int cnt = 0;

	for (int i = 0; i < 8; i++) {
		cin >> temp;
		if (i % 2 == 0) {
			for (auto a : num_even) {
				if (temp[a] == 'F') {
					cnt++;
				}
			}
		}
		else {
			for (auto a : num_odd) {
				if (temp[a] == 'F') {
					cnt++;
				}
			}
		}
	}
	
	cout << cnt;

	

	return 0;
}