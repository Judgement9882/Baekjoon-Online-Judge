// https://www.acmicpc.net/problem/1149

/*
	��Ʈ��ŷ���� �����ϸ� 3^1000 �� ������ �����ϱ⿡
	dp�� �����մϴ�.

	1. �� ����
	D[i][j] = i��° �ǹ��� ���� j����� ĥ��.

	2. ��ȭ��
	D[i][j] = min(D[i-1][(j+1)%3], D[i-1][(j+2)%3]) + cost[i][j]

	3. �ʱⰪ
	i-1 ��°�� ����ؾ��ϰ� j�� ���� %3�� �����ϱ�����
	D[1][0], D[1][1], D[1][2]

*/

#include <bits/stdc++.h>

using namespace std;

int N;
int D[1002][3];
int cost[1002][3];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> cost[i][j];
		}
	}

	D[1][0] = cost[1][0];
	D[1][1] = cost[1][1];
	D[1][2] = cost[1][2];

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 3; j++) {
			D[i][j] = min(D[i - 1][(j + 1) % 3], D[i - 1][(j + 2) % 3]) + cost[i][j];
		}
	}
	
	// ��� 1
	// cout << *min_element(D[N], D[N] + 3);

	// ��� 2
	cout << min({ D[N][0], D[N][1], D[N][2] });

	// ��� 3
	//int mn = min(D[N][0], D[N][1]);
	//mn = min(mn, D[N][2]);
	//cout << mn;
	return 0;
}