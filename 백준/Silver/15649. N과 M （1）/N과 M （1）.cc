#include <bits/stdc++.h>

using namespace std;

int N, M;
int arr[10];
bool vis[10];

void func(int n) {
	
	if (n == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
	}

	for (int i = 1; i <=N; i++) {
		if (vis[i] == 0) {
			arr[n] = i;
			vis[i] = 1;
			func(n + 1);
			vis[i] = 0;
		}
	}

	return;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	
	func(0);

	return 0;
}