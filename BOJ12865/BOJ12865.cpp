// https://www.acmicpc.net/problem/12865

/*
	dp�� ��ǥ���� 0-1 knapsack ����.
	����� ���� ũ�� ������.
	- �ִ´� (���� <= ��ü �뷮) -> max�� ����
	-- �־ ������ P[i-1][w-wi] + pi
	-- �������� P[i-1][w]
	- �ȳִ´� P[i-1][w]
	

*/

#include <bits/stdc++.h>

using namespace std;

int N, K;
pair<int, int> P[102];
int D[102][100002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> K;
	
	for (int i = 1; i <= N; i++) {
		cin >> P[i].first >> P[i].second;
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= K; j++) {
			if (P[i].first <= j) {
				D[i][j] = max(D[i - 1][j], (D[i - 1][j - P[i].first] + P[i].second));
			}
			else {
				D[i][j] = D[i - 1][j];
			}
		}
	}
	
	cout << D[N][K] << "\n";

	return 0;
}