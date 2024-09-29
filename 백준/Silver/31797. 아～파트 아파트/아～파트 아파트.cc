#include <bits/stdc++.h>
#define MAX_N 10001
using namespace std;
int height[MAX_N];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N, M; cin >> N >> M;
	int max_floor = 0;
	vector<pair<int, int>> v;
	for (int i = 1; i <= M; i++) {
		int H1, H2;
		cin >> H1 >> H2;
		v.push_back({ H1, i });
		v.push_back({ H2, i });
	}

	sort(v.begin(), v.end());
	
	for (pair<int, int> cur : v) {
		max_floor++;
		height[max_floor] = cur.second;
	}
	
	int index = 0;
	while (max_floor < N) {
		max_floor++; index++;
		height[max_floor] = height[index];
	}

	cout << height[N];
	return 0;
}