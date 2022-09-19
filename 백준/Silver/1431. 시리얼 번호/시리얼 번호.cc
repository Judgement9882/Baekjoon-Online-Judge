/*
	https://www.acmicpc.net/problem/1431

	시리얼 번호
*/

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int N;
string serialNum[52];

bool cmp(const string& a, const string& b) {
	if (a.length() == b.length()) {
		int a_sum = 0, b_sum = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a[i] - '0' >= 1 && a[i] - '0' <= 9) a_sum += (a[i] - '0');
			if (b[i] - '0' >= 1 && b[i] - '0' <= 9) b_sum += (b[i] - '0');
		}

		// 3의 경우 (길이가 같고 합도 같을경우 사전순으로)
		if (a_sum == b_sum) return a < b;

		// 2의 경우 (합으로 반환)
		return a_sum < b_sum;
	}

	// 1의 경우 (길이로 반환)
	return a.length() < b.length();
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> serialNum[i];
	}

	sort(serialNum, serialNum + N, cmp);
	
	for (int i = 0; i < N; i++) {
		cout << serialNum[i] << "\n";
	}
	return 0;
}