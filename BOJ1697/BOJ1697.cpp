#include <bits/stdc++.h>

using namespace std;

int dist[100002];

int N, K;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> K;

	fill(dist, dist+ 100001, -1);
	dist[N] = 0;

	queue<int> Q;
	Q.push(N);

	while (dist[K] == -1) {
		auto cur = Q.front();
		Q.pop();

		for (int i : {cur - 1, cur + 1, 2 * cur}) {
			if (i < 0 || i > 100000) continue;
			if (dist[i] != -1) continue;
			dist[i] = dist[cur] + 1;
			Q.push(i);
		}
	}

	cout << dist[K];
	return 0;
}