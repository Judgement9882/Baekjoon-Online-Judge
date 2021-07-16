// https://www.acmicpc.net/problem/1026

#include <bits/stdc++.h>

using namespace std;

int A[52];
int B[52];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> B[i];
	}
	sort(A, A + N);
	sort(B, B + N, greater<>());

	int cnt = 0;
	for (int i = 0; i < N; i++) {
		cnt += A[i] * B[i];
	}
	cout << cnt;
	return 0;
}