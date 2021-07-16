// https://www.acmicpc.net/problem/11659

/*
	- basic idea 
	그냥 배열에다가 삽입해서 구현하려고 했지만
	최대 1x10^5 까지 입력하고 1x10^5 번 참조하기 때문에
	총 1x10^10 = 100억
	따라서 통상 1억 안쪽이 아니므로 시간초과 발생
	따라서 dp관점에서 접근

	- dp
	num[1] + ... + num[i] = D[i] 라 정의하는건 O(N^2)
	D[i] = D[i-1] + num[i] 로 정의 -> O(N)
	따라서
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