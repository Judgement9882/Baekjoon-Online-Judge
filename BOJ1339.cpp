// https://www.acmicpc.net/problem/1339
/*
	각 자리수에 해당하는 10의 제곱을 곱하여 알파벳 배열에 더하고
	그 중 가장 큰 값에 큰 수를 부여.
*/

#include <bits/stdc++.h>

using namespace std;

int N;
int alpha[30];

int main() {
	
	cin.tie(0);
	ios::sync_with_stdio(0);
	cin >> N;

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;

		for (int j = 0; j < temp.length(); j++) {
			int asc = temp[j] - 65;
			alpha[asc] += int(pow(10, temp.length() - j - 1));
		}

	}
	sort(alpha, alpha+30, greater<>());

	int cnt = 0;
	int num = 9;

	/*
	for (int i = 0; i < 10; i++) {
		cout << "alpha\n" << alpha[i] << "\n";
	}
	*/

	for (int j = 0; j < 30; j++) {
		if (alpha[j] == 0) {
			cout << cnt;
			return 0;
		}
		cnt += alpha[j] * num--;
	}
	return 0;
}