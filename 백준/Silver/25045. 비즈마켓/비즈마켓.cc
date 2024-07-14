#include <iostream>
#include <algorithm>
#include <vector>

#define ll long long
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, M; cin >> N >> M;
	vector<ll> A, B;

	for (int i = 0; i < N; i++) {
		ll num; cin >> num; A.push_back(num);
	}
	sort(A.begin(), A.end(), cmp);
	
	for (int i = 0; i < M; i++) {
		ll num; cin >> num; B.push_back(num);
	}
	sort(B.begin(), B.end());

	ll ans = 0;
	for (int i = 0; i < min(N, M); i++) {
		if (A[i] > B[i]) {
			ans += A[i] - B[i];
		}
	}

	cout << ans;
	return 0;
}