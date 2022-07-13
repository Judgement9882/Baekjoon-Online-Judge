/*
	https://www.acmicpc.net/problem/2935

	수학문제 풀이
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string first, second;
	char op;

	cin >> first >> op >> second;

	// 길이가 긴것을 무조건 first로.
	if (first.length() < second.length()) swap(first, second);

	// 더하기
	if (op == '+') {
		// 같을 경우 0번째 index를 2로 바꿔줌
		if (first.length() == second.length()) first[0] = '2';
		else {
			first[first.length() - second.length()] = '1';
		}

		cout << first;
	}

	// 곱하기
	else if (op == '*') {
		cout << 1;
		for (int i = 1; i < first.length() + second.length() - 1; i++) {
			cout << 0;
		}
	}

	return 0;
}



