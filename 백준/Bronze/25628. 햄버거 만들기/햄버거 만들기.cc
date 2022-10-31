/*
	https://www.acmicpc.net/problem/25628

	햄버거만들기
*/

#include <iostream>
#include <algorithm>
using namespace std;


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int A, B;
	cin >> A >> B;
	cout << min(A / 2, B);
	return 0;
}