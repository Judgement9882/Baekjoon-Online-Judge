// https://www.acmicpc.net/problem/2579
/*
	- basic idea : dp
	
	1. ���� �����ϱ�
	d[i][j] = ������� j���� ����� �����ؼ� ���
	i��° ��ܱ��� �ö��� �� ���� ���� �ִ�
	(�� i ��° ����� �ݵ�� ��ƾ���.
	-> j�� 1�ƴϸ� 2�ϼ��ۿ� ����.)

	2. ��ȭ��
	d[k][1] : ���� 1���� ����� �����ؼ� ����ְ�, k��° ��ܿ� �ö������.
	-> k-1�� �������� -> ������ �ִ밪�� d[k-2][1] or d[k-2][2] �� ����Ǿ�����
	----> d[k][1] = max(d[k-2][1], d[k-2][2]) + S[k] 
	���⼭ S[k]�� k��° ����� ��.

	d[k][2] : ���� 2��° ����� �����ؼ� �������.
	���� ������ �ִ밪�� d[k-1][1] �� ����Ǿ�����.
	(d[k-1][2] �� �ȵ�. �������� ����������)
	���� d[k][2] = d[k-1][1] + S[k]

	���� max(d[n][1], d[n][2]) ���

	3. �ʱⰪ
	d[1][1]
	d[1][2]
	d[2][1]
	d[2][2]

*/

// ������ �迭 �̿�
//#include <bits/stdc++.h>
//
//using namespace std;
//
//int point[302];
//int d[305][3];
//int N;
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	cin >> N;
//
//	for (int i = 1; i <= N; i++) {
//		cin >> point[i];
//	}
//	if (N == 1) {
//		cout << point[1];
//		return 0;
//	}
//
//	d[1][1] = point[1];
//	d[1][2] = 0;
//	d[2][1] = point[2];
//	d[2][2] = point[1] + point[2];
//
//	for (int i = 3; i <= N; i++){
//		d[i][1] = max(d[i - 2][1], d[i - 2][2]) + point[i];
//		d[i][2] = d[i - 1][1] + point[i];
//	}
//
//	cout << max(d[N][1], d[N][2]);
//
//	return 0;
//}

/*
	1. D����
	D[i] : i��° ��ܿ����� �������� ��� ���� �ּڰ�.
	�� i��°�� ��������.
	
	2. ��ȭ��
	D[i] = min(D[i-2], D[i-3]) + S[i]

	3. �ʱⰪ
	D[1], D[2], D[3] 

*/


#include <bits/stdc++.h>

using namespace std;

int point[305];
int d[305];
int N;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	int total_sum = 0;
	for (int i = 1; i <= N; i++) {
		cin >> point[i];
		total_sum += point[i];
	}

	if (N <= 2) {
		cout << total_sum;
		return 0;
	}
	
	d[1] = point[1];
	d[2] = point[2];
	d[3] = point[3];
	for (int i = 4; i <= N; i++) {
		d[i] = min(d[i - 2], d[i - 3]) + point[i];
	}
	cout << total_sum - min(d[N - 1], d[N - 2]);

	return 0;
}