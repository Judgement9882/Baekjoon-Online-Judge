#include <iostream>
using namespace std;
int Moo[9] = { 0, 1, 2, 4, 7, 8, 11, 13, 14 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	int quo = (N-1) / 8;
	int rem = N % 8;
	if (rem == 0) rem = 8;
	cout << quo * 15 + Moo[rem];
	return 0;
}