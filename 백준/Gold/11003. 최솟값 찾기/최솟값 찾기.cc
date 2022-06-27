/*
	https://www.acmicpc.net/problem/11003

	최솟값 찾기
	
	
*/

#include <iostream>
#include <deque>

using namespace std;

deque<pair<int, int>> dq;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, L, A; cin >> N >> L;

	for (int i = 0; i < N; i++) {
		cin >> A;

		// dq가 비어있지 않고 오른쪽 수보다 새로들어온 수가 작다면 pop_back
		while (!dq.empty() && dq.back().first > A) dq.pop_back();

		dq.push_back({ A, i });

		// L 크기의 범위를 넘어서는 수는 제거

		if (dq.front().second < i - L + 1) dq.pop_front();

		cout << dq.front().first << " ";
	}
	return 0;
}