/*
	https://www.acmicpc.net/problem/3460
	
	이진수
*/

#include <iostream>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int T, N;
	cin >> T;
	
	while (T--) {
		cin >> N;
		
		int i = 0;

		while (N>0) {
			if (N % 2 == 1) {
				cout << i << " ";
			}

			N /= 2;
			i++;
		}
	}
}