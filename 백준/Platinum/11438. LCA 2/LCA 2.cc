#include <iostream>
#include <vector>

#define MAX_NODE 100001
#define MAX_H 20

using namespace std;

int N, u, v;
int parent[MAX_NODE][MAX_H], depth[MAX_NODE], h = 0;
vector<int> edge[MAX_NODE];

void findParent(int par, int node, int dep) {
	int numOfEdge = edge[node].size();
	if (numOfEdge == 0) return; // 자식이 없으면 return
	parent[node][0] = par; // 부모 노드 초기화
	depth[node] = dep; // 깊이 초기화
	for (int i = 0; i < numOfEdge; ++i) { // 자식 순회
		if (edge[node][i] != par)
			findParent(node, edge[node][i], dep + 1);
	}	
}

int findLCA(int x, int y) {
	// 1. depth 일치
	// 비트 연산을 통해 최대 높이부터 계산.
	// ex) 15, 3 이라면 12만큼 올라가야함 -> 8 4 올라감 -> 1100
	for (int i = h; i >= 0; --i) {
		if (depth[x] > depth[y] && ((depth[x] - depth[y]) & (1 << i)))
			x = parent[x][i];
		if (depth[y] > depth[x] && ((depth[y] - depth[x]) & (1 << i)))
			y = parent[y][i];
	}
	
	// 높이가 같아졌는데 같은 노드다? LCA
	if (x == y) return x;

	int node1 = x;
	int node2 = y;

	// 이분 탐색 느낌으로 진행.
	// 2^i 만큼 올라가보고 같다? -> 갱신x
	// 같지 않다? 2^i만큼 올라감
	// => 최종적으로 node1, node2는 LCA 전 단계 노드까지 올라감
	// ==> parent[node1][0] 즉, node1의 부모를 return 하면 LCA.

	for (int i = h; i >= 0; --i) {
		if (parent[node1][i] != parent[node2][i]) {
			node1 = parent[node1][i];
			node2 = parent[node2][i];
		}
	}
	return parent[node1][0];
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	cin >> N;
	for (int i = 0; i < N - 1; i++) {
		cin >> u >> v;
		edge[u].push_back(v);
		edge[v].push_back(u);
	}

	findParent(0, 1, 0);

	int temp = N;
	// 최대 높이 계산
	while (temp > 1) {
		temp /= 2; // 2로 나누어도 2^i 만큼 점프를 하기 때문에 최대가 됨.
		h++;
	}

	// O(nlogn)
	for (int i = 1; i <= h; i++) { // parent[node][0]은 이미 있으니 1부터
		for (int node = 2; node <= N; node++) { // 1번은 root니까 2번부터
			if (parent[node][i - 1])  // 만약 i-1 단계의 parent 배열이 0이 아니면 i 단계 갱신 가능
				parent[node][i] = parent[parent[node][i - 1]][i - 1];
		}
	}

	int M; cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> u >> v; // 공통 조상 알고 싶은 두 정점
		cout << findLCA(u, v) << "\n";
	}

	return 0;
}