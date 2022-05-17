/*
	https://www.acmicpc.net/problem/13752

	히스토그램

*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, histo;
	cin >> N;

	while (N--) {
		cin >> histo;
		while (histo--) {
			cout << '=';
		}
		cout << "\n";
	}
	
	return 0;
}