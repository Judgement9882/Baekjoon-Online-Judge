#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int M, S, G, L, R;
	double A, B;
	cin >> M >> S >> G >> A >> B >> L >> R;
	
	double waitL = L / A + M/G;
	double walkR = R / B + M/S; 
	cout << (waitL > walkR ? "latmask" : "friskus");

	return 0;
}