#include <bits/stdc++.h>
using namespace std;

int N, M;
int arr[10];
vector<int> v;

void func(int index, int cur) {
	if (cur == M) {
		for (int i = 0; i < M; i++) {
			cout << v[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = index; i < N; i++) {
		v.push_back(arr[i]);
		func(i+1, cur+1);
		v.pop_back();
	}
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int temp;
		cin >> temp;
		arr[i] = temp;
	}

	sort(arr, arr + N);

	for (int i = 0; i < N; i++) {
		v.push_back(arr[i]);
		func(i+1, 1);
		v.pop_back();
	}

	return 0;
}