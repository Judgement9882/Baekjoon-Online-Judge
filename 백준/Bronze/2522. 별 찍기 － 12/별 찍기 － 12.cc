/*
	https://www.acmicpc.net/problem/2522
	
	별 찍기 12
*/

#include <iostream>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int k = N; k > i; k--) {
			cout << " ";
		}
		for (int j = 0; j < i; j++) {
			cout << "*";
		}
		cout << "\n";
	}
	for (int i = N-1; i > 0; i--) {
		for (int k = N; k > i; k--) {
			cout << " ";
		}
		for (int j = 0; j < i; j++) {
			cout << "*";
		}
		cout << "\n";
	}
}