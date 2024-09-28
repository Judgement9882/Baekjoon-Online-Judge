#include <bits/stdc++.h>
#define MAX_N 1001
using namespace std;
int arr[MAX_N], answer[MAX_N];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int N; cin >> N;
	queue<int> q;
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
		q.push(i);
	}
	int time = 0;
	while (!q.empty()) {
		++time;
		int cur = q.front(); q.pop();
		if (arr[cur] == 1) answer[cur] = time;
		else {
			--arr[cur];
			q.push(cur);
		}
	}
	
	for (int i = 1; i <= N; i++) {
		cout << answer[i] << " ";
	}

	return 0;
}