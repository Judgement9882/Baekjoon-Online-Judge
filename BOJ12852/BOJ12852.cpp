// https://www.acmicpc.net/problem/12852

/*
	1�� ����� ù��° ������ ���� �ذ��ϸ鼭
	������ ������ ����ϴ� ����.

	�� ������ �б⺰�� ����.

	���� ���� �ε����� ���� �ε��� ���ΰ��� �̿��Ͽ� ���

*/

#include <bits/stdc++.h>

using namespace std;

int N;
int d[1000002];
int tem[1000002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	d[1] = 0;

	for (int i = 2; i <= N; i++) {
		d[i] = d[i - 1] + 1;
		tem[i] = i - 1;

		if (i % 2 == 0) {	
			if (d[i] > d[i / 2] + 1) {
				d[i] = d[i / 2] + 1;
				tem[i] = i / 2;
			}
		}
		if (i % 3 == 0) {
			if (d[i] > d[i / 3] + 1) {
				d[i] = d[i / 3] + 1;
				tem[i] = i / 3;
			}
		}
	}

	cout << d[N] << "\n";
	int cur = N;
	while (1) {
		cout << cur << " ";
		if (cur == 1) break;
		cur = tem[cur];
	}

	return 0;
}