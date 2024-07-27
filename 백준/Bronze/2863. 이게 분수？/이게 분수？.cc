#include <iostream>
using namespace std;
double A, B, C, D;

void rotate90() {
	double temp = D;
	D = B;
	B = A;
	A = C;
	C = temp;
}

double cal() {
	return A / C + B / D;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> A >> B >> C >> D;
	double ans_num = 0;
	int ans = 0;
	for (int i = 0; i < 4; i++) {
		double num = cal();
		if (num > ans_num) {
			ans_num = num;
			ans = i;
		}
		rotate90();
	}
	cout << ans;
	return 0;
}