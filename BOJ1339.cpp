// https://www.acmicpc.net/problem/1339
/*
	�� �ڸ����� �ش��ϴ� 10�� ������ ���Ͽ� ���ĺ� �迭�� ���ϰ�
	�� �� ���� ū ���� ū ���� �ο�.
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