#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b) {
	if (a == 0) return b;
	return gcd(b%a, a);
}

int lcd(int a, int b) {
	return a / gcd(a, b) * b;
}

int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);
	int N;
	cin >> N; 
	while (N--) {
		int a, b; cin >> a >> b;
		cout << lcd(a, b) << " " << gcd(a, b) << "\n";
	}
	
	

	return 0;
}