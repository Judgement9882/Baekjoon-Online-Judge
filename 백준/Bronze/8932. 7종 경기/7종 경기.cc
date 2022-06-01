/*
	https://www.acmicpc.net/problem/9316
	
	Hello judge
*/

#include <iostream>
#include <cmath>

using namespace std;

int main() {

	float A[7] = { 9.23076, 1.84523, 56.0211, 4.99087, 0.188807, 15.9803, 0.11193 };
	float B[7] = { 26.7, 75, 1.5, 42.5, 210, 3.8, 254 };
	float C[7] = { 1.835, 1.348, 1.05, 1.81, 1.41, 1.04, 1.88 };

	cin.tie(0);
	ios::sync_with_stdio(0);
	int T, P;
	cin >> T;

	while (T--) {
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			cin >> P;
			if (i == 0 || i == 3 || i == 6) {
				cnt += int(A[i] * pow((B[i] - P), C[i]));
			}
			else {
				cnt += int(A[i] * pow((P - B[i]), C[i]));
			}
		}
		

		cout << cnt << "\n";
	}

	return 0;
}
