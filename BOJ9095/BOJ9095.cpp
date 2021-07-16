// https://www.acmicpc.net/problem/9095

/*
	- basic idea

	dp�� �̿��Ͽ� Ǯ��.
	1. ���̺� �����ϱ�
	d[i] = i �� 1,2,3�� ������ ��Ÿ���� �ִ� ���

	2. ��ȭ��
	d[2] = 2 // 1+1, 2
	d[3] = 4 // 1+1+1, 1+2, 2+1, 3
	d[4] = 1+1+1+1 1+2+1 2+1+1 3+1 (3�� 123 ������ ��Ÿ���¹�� + 1)
			1+1+2 2+2 (2�� 1,2,3 ������ ��Ÿ���¹�� + 2)
			1+3 ( 1�� 1 2 3 ������ ��Ÿ���� ��� + 3)

	�� d[n] = d[n-1]+d[n-2]+d[n-3]
	3. �ʱⰪ
	d[1] = 1
	d[2] = 2
	d[3] = 4

*/

#include <bits/stdc++.h>
using namespace std;

int T, N;
int d[15];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> T;
	
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 4; i <= 11; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
	}
	while(T--){
		cin >> N;
		cout << d[N] << "\n";
	}

	return 0;
}