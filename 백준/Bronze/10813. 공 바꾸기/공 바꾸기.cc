/*
	https://www.acmicpc.net/problem/10813
	
	공 바꾸기
*/

#include <iostream>
#include <algorithm>
using namespace std;

int num[102];

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N, M, front, back;
	cin >> N >> M;
	for (int i = 1; i <= N; i++) num[i] = i;
	while (M--) {
		cin >> front >> back;
		swap(num[front], num[back]);
	}

	for (int i = 1; i <= N; i++) cout << num[i] << " ";
	return 0;
}
