/*
	https://www.acmicpc.net/problem/1003

	피보나치 수열에서 1, 0을 몇번씩 호출했는가

	0 => 0 한번
	1 => 1 한번
	2 => 1, 0 => 0 한번 1 한번
	3 => 2, 1 => 1 0 1 => 1 두번 0 한번
	4 => 3, 2 => 1 세번 0 두번
	5 => 4, 3 => 
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// first = 0, second = 1
int fibo_zero[42];
int fibo_one[42];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	fibo_zero[0] = 1;
	fibo_zero[1] = 0;

	fibo_one[0] = 0;
	fibo_one[1] = 1;

	for (int i = 2; i < 41; i++) {
		fibo_zero[i] = fibo_zero[i - 1] + fibo_zero[i - 2];
		fibo_one[i] = fibo_one[i - 1] + fibo_one[i - 2];
	}

	int T;
	cin >> T;

	while (T--) {
		int N;
		cin >> N;
		cout << fibo_zero[N] << " " << fibo_one[N] << "\n";
	}


	return 0;
}