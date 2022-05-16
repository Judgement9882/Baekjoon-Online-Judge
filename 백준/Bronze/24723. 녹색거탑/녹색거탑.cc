/*
	https://www.acmicpc.net/submit/24723

	탑 내려가기

*/

#include <iostream>

using namespace std;



int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, val=1;
	cin >> N;

	for (int i = 0; i < N; i++) {
		val *= 2;
	}
	cout << val;
	
	return 0;
}