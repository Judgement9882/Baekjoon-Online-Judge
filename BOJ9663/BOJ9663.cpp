#include <bits/stdc++.h>

using namespace std;

int N, cnt;

bool vis1[40]; // horizon
bool vis2[40]; // +x +y
bool vis3[40]; // +x -y

void func(int cur) {
	
	if (N == cur) {
		cnt++;
		return;
	}

	for (int i = 0; i < N; i++) {
		if (vis1[i] || vis2[i + cur] || vis3[cur - i + N - 1])
			continue;
		
		vis1[i] = 1;
		vis2[i+cur] = 1;
		vis3[cur-i+N-1] = 1;
		func(cur + 1);
		vis1[i] = 0;
		vis2[i + cur] = 0;
		vis3[cur - i + N - 1] = 0;
	}

}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N;
	
	func(0);
	cout << cnt;

	return 0;
}