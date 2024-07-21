#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool cmp(int a, int b) {
	return a > b;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	vector<int> flowers(N);
	for (int i = 0; i < N; i++) {
		cin >> flowers[i];
	}
	int ans = 0;
	sort(flowers.begin(), flowers.end(), cmp);

	for (int i = 0; i < N - 1; i++) {
		if (flowers[i] % 2 == 1) ans += flowers[i];
		else ans += flowers[i] - 1;
	}
	
	if (N % 2 == 1) {
		if (flowers[N-1] % 2 == 1) ans += flowers[N-1];
		else ans += flowers[N-1] - 1;
	}

	cout << ans;
	
	return 0;
}