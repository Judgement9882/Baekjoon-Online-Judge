/*
	https://www.acmicpc.net/problem/23825

	SASA

*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	cin >> N >> M;

	cout << min(N, M) / 2;
	
	return 0;
}