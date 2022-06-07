/*
	https://www.acmicpc.net/problem/2738

	행렬덧셈
*/

#include <iostream>

using namespace std;

int A[102][102];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M, num;
	
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> A[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> num;
			A[i][j] += num;
		}
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cout << A[i][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}