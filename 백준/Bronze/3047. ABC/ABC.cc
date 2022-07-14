/*
	https://www.acmicpc.net/problem/3047

	ABC
*/

#include <iostream>
#include <algorithm>

using namespace std;

int ABC[3];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	
	int a, b, c;
	cin >> a >> b >> c;
	if (a >= c) swap(a, c);
	if (a >= b) swap(a, b);
	if (b >= c) swap(b, c);

	ABC[0] = a;
	ABC[1] = b;
	ABC[2] = c;

	string temp;
	cin >> temp;
	for (int i = 0; i < 3; i++) {
		cout << ABC[temp[i] - 'A'] << " ";
	}

	return 0;
}



