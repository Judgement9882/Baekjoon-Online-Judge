#include <bits/stdc++.h>

using namespace std;

int N, S;
int arr[22];
int cnt = 0;

void func(int cur, int num) {
	if (cur == N) {
		if (num == S) {
			cnt++;
		}
		
		return;
	}

	func(cur + 1, num); // ������ ������ ����
	func(cur + 1, num + arr[cur]); // ������ ����
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	func(0, 0);
	if (S == 0) { // �������� ����
		cnt--;
	}
	
	cout << cnt;
	return 0;
}