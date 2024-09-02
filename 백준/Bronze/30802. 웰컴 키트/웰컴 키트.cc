#include <iostream>

using namespace std;
int arr[6];
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	for (int i = 0; i < 6; ++i) cin >> arr[i];
	int T, P; cin >> T >> P;
	
	int ans = 0;
	for (int i = 0; i < 6; ++i) {
		if (arr[i] % T != 0) ++ans;
		ans += arr[i] / T;
	}
	cout << ans << "\n";
	cout << N / P  << " " << N % P;

	return 0;
}