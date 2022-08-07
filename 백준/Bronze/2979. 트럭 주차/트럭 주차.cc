/*
	https://www.acmicpc.net/problem/2979

	트럭
*/

#include <iostream>
#include <algorithm>
using namespace std;

bool truck[3][102] ;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int A_fee, B_fee, C_fee;
	cin >> A_fee >> B_fee >> C_fee;

	int T = 3;
	int max_length = -99;
	for(int i = 0 ; i < T ; i++) {
		int front, back;
		cin >> front >> back;
		max_length = max(max_length, back);
		for (int j = front; j < back; j++) {
			truck[i][j] = 1;
		}
	}
	int cnt = 0;
	for (int i = 1; i <= max_length; i++) {
		int sum = 0;
		for (int j = 0; j < T; j++) if (truck[j][i]) sum++;

		if (sum == 1) cnt += sum * A_fee;
		if (sum == 2) cnt += sum * B_fee;
		if (sum == 3) cnt += sum * C_fee;
		// cout << i << " " << sum << " " << cnt << "\n";
	}
	cout << cnt;
	return 0;
}