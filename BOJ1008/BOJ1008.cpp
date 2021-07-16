#include <iostream>

using namespace std;

int main() {

	// I/O speed management
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	double A, B;
	cin >> A >> B;

	cout << fixed;
	cout.precision(10);

	cout << A / B;
}