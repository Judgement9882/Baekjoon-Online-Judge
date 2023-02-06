// boj 1854
// https://www.acmicpc.net/problem/1854
// 틀린 이유 : 우선순위큐를 이용하여 거리를 저장하지 않았음.

#include <iostream>
#include <vector>
#include <queue>

#define INF 987654321

using namespace std;

struct Data {
	int node;
	int weight;

	Data() {};
	Data(int node, int weight) : node(node), weight(weight) {}; // 생성자

	// 우선순위큐에서 weight를 바탕으로 오름차순 정렬해야하므로
	bool operator<(const Data d) const {
		return weight > d.weight;
	}
};

vector<Data> v[1002]; // 데이터 저장
priority_queue<Data> q; // 우선순위큐
priority_queue<int> pq[1001]; // k번째 최단거리를 저장하기 위한 우선순위큐

int N, M, k;
int a, b, c;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M >> k;

	// 초기화
	priority_queue<int> emptyPQ;
	priority_queue<Data> emptyQ;
	for (int i = 0; i <= N; i++) {
		v[i].clear(); // 언제 어떻게 데이터가 들어갈 지 모르니 클리어해주는게 좋음
		swap(pq[i], emptyPQ);
	}
	swap(q, emptyQ);

	for (int i = 0; i < M; i++) {
		cin >> a >> b >> c;
		// 양방향
		v[a].push_back(Data(b, c));
	}

	q.push(Data(1, 0)); // 우선순위큐에 노드1, 가중치 0 넣기.
	pq[1].push(0); // 시작 노드는 1

	while (!q.empty()) {
		Data now = q.top(); q.pop(); // 데이터 꺼내고 삭제

		for (int i = 0; i < v[now.node].size(); i++) { // 현재 방문한 노드에 연결된 간선의 개수만큼 비교
			Data next = v[now.node][i]; // 다음 방문하게 될 노드의 정보
			if (pq[next.node].size() < k) { // k보다 작다면 저장
				pq[next.node].push(now.weight + next.weight);
				q.push(Data(next.node, (now.weight + next.weight)));
			}
			else {
				int cmp = pq[next.node].top();
				if (cmp > now.weight + next.weight) {
					pq[next.node].pop();
					pq[next.node].push(now.weight + next.weight);
					q.push(Data(next.node, (now.weight + next.weight)));
				}
			}
		}
	}

	for (int i = 1; i <= N; i++) {
		if (pq[i].size() >= k) {
			cout << pq[i].top() << "\n";
		}
		else {
			cout << "-1\n";
		}
	}

	return 0;
}
