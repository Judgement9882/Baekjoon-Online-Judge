/*
	https://www.acmicpc.net/problem/15819

	너의핸들은
*/

#include <iostream>
#include <algorithm>

using namespace std;

string handle[102];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, I;
	cin >> N >> I;
	for (int i = 1; i <= N; i++) cin >> handle[i];
	sort(handle+1, handle + N+1);
	cout << handle[I];

	return 0;
}