#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b) {
	if (a == 0) return b;
	return gcd(b%a, a);
}

int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);
	

	int N;
	cin >> N;

	int num = 0;

	if (N == 2) {
		int a, b; cin >> a >> b;
		num = gcd(a, b);
	}
	else {
		int a, b, c; cin >> a >> b >> c;
		num = gcd(gcd(a, b), c);
	}

	for (int i = 1; i <= num; i++) {
		if (num % i == 0) cout << i << "\n";
	}
		
	

	

	return 0;
}