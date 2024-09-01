#include <iostream>

using namespace std;

int N, M;
int p[200005]; // 부모
int num[200005];

// 자기 자신으로 초기화
void makeSet() {
	for (int i = 1; i <= N; i++) p[i] = i;
}

// 부모 찾기
int findSet(int a) {
	if (p[a] == a) return a;
	return p[a] = findSet(p[a]); // 경로 압축
}

bool unionSet(int a, int b) {
	int aRoot = findSet(a);
	int bRoot = findSet(b);
	
	if (aRoot == bRoot) return false; // 이미 같은 집합
	p[bRoot] = aRoot; // union
	return true;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	makeSet();
	while (M--) {
		int u, v;
		cin >> u >> v;
		unionSet(u, v);
	}

	long ans = 1;
	for (int i = 1; i <= N; i++) num[findSet(i)]++;
	for (int i = 1; i <= N; i++) {
		if (num[i] != 0) {
			ans = ans * num[i];
			ans %= 1000000007;
		}
		
	}
	cout << ans;
	return 0;
}