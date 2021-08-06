#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	int a, b, c, d, e, f;
	cin >> a >> b >> c >> d >> e >> f;

	int smallest = 999;
	smallest = min(smallest, a);
	smallest = min(smallest, b);
	smallest = min(smallest, c);
	smallest = min(smallest, d);
	e = max(e, f);
	cout << a + b + c + d - smallest + e << "\n";
	
	cout << smallest << "\n";
	cout << e;

	return 0;
}