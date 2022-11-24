#include <iostream>
#include <algorithm>
using namespace std;



int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);

	int a, b; cin >> a >> b;
	if (b > a) {
		cout << b % a;
	}
	else {
		cout << a + b;
	}

	return 0;
}