// https://www.acmicpc.net/problem/11659

/*
	- basic idea 
	�׳� �迭���ٰ� �����ؼ� �����Ϸ��� ������
	�ִ� 1x10^5 ���� �Է��ϰ� 1x10^5 �� �����ϱ� ������
	�� 1x10^10 = 100��
	���� ��� 1�� ������ �ƴϹǷ� �ð��ʰ� �߻�
	���� dp�������� ����

	- dp
	num[1] + ... + num[i] = D[i] �� �����ϴ°� O(N^2)
	D[i] = D[i-1] + num[i] �� ���� -> O(N)
	����
	num[i] + ... + num[j]
	= D[j] - D[i-1]
	
*/

#include <bits/stdc++.h>

using namespace std;

int N, M;
int num[100002];
int D[100002];


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N >> M;
	D[0] = 0;
	for (int i = 1; i <= N; i++) {
		cin >> num[i];
		D[i] = D[i - 1] + num[i];
	}

	while (M--) {
		int i, j;
		cin >> i >> j;
		cout << D[j] - D[i - 1] << "\n";
	}
	
	return 0;
}