#include <bits/stdc++.h>
using namespace std;
long long arr[3];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	for (int i = 0; i < 3; i++) cin >> arr[i];
	sort(arr, arr + 3);
	cout << arr[1];
	return 0;
}