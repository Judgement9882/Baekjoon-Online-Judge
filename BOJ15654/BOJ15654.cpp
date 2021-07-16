#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> v;
bool check[10];
vector<int> arr;
void func(int cur) {
	if (cur == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = 0; i < N; i++) {
		if (!check[i]) {
			arr.push_back(v[i]);
			check[i] = 1;
			func(cur + 1);
			check[i] = 0;
			arr.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int temp;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());

	func(0);

	return 0;
}