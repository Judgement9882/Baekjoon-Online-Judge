#include <bits/stdc++.h>
using namespace std;

int rope[100002];
int N;

int main(){
	
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> rope[i];
	}

	sort(rope, rope + N);

	int mn = 0;
	for (int i = 0; i < N; i++) {
		mn = max(mn, rope[i] * (N - i));
	}
	cout << mn;

	return 0;
}