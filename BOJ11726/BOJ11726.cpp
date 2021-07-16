// https://www.acmicpc.net/problem/11726

/*
	dp�� �ذ�.
	
	1. ����
	D[i] = N�� i �϶� ���簢���� ä�� �� �ִ� ����� ��

	2. ��ȭ��
	-> ù ���� �ι�° ���� ���ι������� ������
	D[N-2] ��찡 ������, ù��° ���� ���η� ������Ű��
	D[N-1] �� ������ ��찡 ���ɴϴ�. �� �ΰ�츦 ���ϸ�
	��ġ�� ������ ���ɴϴ�.

	D[N] = D[N-1]+D[N-2]

	3. �ʱ�ȭ
	D[1] = 1
	D[2] = 2
*/

#include <bits/stdc++.h>
using namespace std;

int D[1002];
int N;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	D[1] = 1;
	D[2] = 2;
	if (N <= 2) {
		cout << D[N];
		return 0;
	}

	for (int i = 3; i <= N; i++) {
		D[i] = (D[i - 1] + D[i - 2]) % 10007;
	}
	cout << D[N];
	return 0;
}