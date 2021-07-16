// https://www.acmicpc.net/problem/1463

/*
	- basic idea
	: �� �� �ִ� ������ ������ 3���� �ۿ� ����
	������ ���� ����� ī���Ͱ��� ���� ��������
	����ϸ� �˴ϴ�. 
	
	-> but �ð��ʰ�, ���ٹ�ĵ� ��Ʈ��ŷ�� �ƴ϶�
	bfs�� ����.
	
	- reference idea
	: dp�� ����.
	1. ���̺� �����ϱ�
	: D[i] = i �� 1�� ����� ���� �ʿ��� ���� ��� Ƚ���� �ּڰ�
	2. ��ȭ�� ã��.
	: D[k] = ?
	D[k] = D[k/3] + 1
	D[k] = D[k/2] + 1
	D[k] = D[k-1] + 1
	-> min(D[k/1] + 1 , D[k/2] + 1, D[k-1] + 1)

	3. �ʱⰪ �����ϱ�
	D[1] = 0


*/

// ó������
//#include <bits/stdc++.h>
//
//using namespace std;
//
//int N;
//int mv = 999;
//
//void func(int n, int cnt) {
//	
//	if (n == 1) {
//		mv = min(mv, cnt);
//		return;
//	}
//	if (n % 3 == 0) {
//		func(n / 3, cnt + 1);
//	}
//	else if (n % 2 == 0) {
//		func(n / 2, cnt + 1);
//	}
//	
//	func(n - 1, cnt + 1);
//	
//}
//
//int main() {
//	
//	cin >> N;
//
//	func(N, 0);
//	cout << mv;
//	return 0;
//}


#include <bits/stdc++.h>
using namespace std;

int d[1000005];
int n;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	d[1] = 0; // 3. �ʱⰪ ����
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0) {
			d[i] = min(d[i], d[i / 2] + 1);
		}
		if (i % 3 == 0) {
			d[i] = min(d[i], d[i / 3] + 1);
		}
	}
	cout << d[n];


	return 0;
}