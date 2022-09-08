/*
	https://www.acmicpc.net/problem/15059

	Hard Choice
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int a, b, c; cin >> a >> b >> c;
	int d, e, f; cin >> d >> e >> f;
	int sum = 0;
	if (a < d) sum += (d - a);
	if (b < e) sum += (e - b);
	if (c < f) sum += (f - c);
	
	cout << sum;


	return 0;
}