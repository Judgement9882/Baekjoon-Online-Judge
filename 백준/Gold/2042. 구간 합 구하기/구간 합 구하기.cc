// 2042 구간 합 구하기
// 배열로 하면 시간초과.
// index tree로 풀자

#include <iostream>

#define MAX 21

using namespace std;

int N, M, K, B, a, b;
long long c;

long long indexT[1 << MAX];

void init_indexT() {
	// B-1번 부터(상위 깊이의 제일 오른쪽 노드)
	// root 노드까지 합으로 값을 채움
	for (int i = B - 1; i > 0; i--) {
		indexT[i] = (indexT[i << 1] + indexT[(i << 1) | 1]);
	}
}

void update(int b, long long c) {
	b += (B - 1); // 바꾸고자 하는 leaf node 인덱스
	indexT[b] = c;
	
	// indexT[b]를 바꿨으니, 
	while (b >>= 1) {
		indexT[b] = (indexT[b << 1] + indexT[(b << 1) | 1]);
	}
}

long long sum(int l, int r) {
	l += B - 1; // 트리에 맞게 인덱스 설정 
	r += B - 1; // 트리에 맞게 인덱스 설정

	long long sumT = 0;

	while (l <= r) {
		// 왼쪽 노드가 트리에서 오른쪽에 있다면 더함(그 노드의 부모노드는 안씀)
		if ((l & 1) == 1) sumT += indexT[l];

		// 오른쪽 노드가 트리에서 왼쪽에 있다면 더함(그 노드의 부모노드는 안씀)
		if ((r & 1) == 0) sumT += indexT[r];

		// l,r은 확인했으니 가까워지는 방향으로 이동하고 부모노드로 이동
		l = (l + 1) >> 1;
		r = (r - 1) >> 1;
	}
	return sumT;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> N >> M >> K;
	
	// index 트리의 leaf노드 수 구하기
	for (B = 1; B < N; B <<= 1);
	
	// leaf노드 시작부터(B) N+B 까지 leaf노드를 채움
	// 빈 노드는 그냥 둠.
	for (int i = B; i < N+B; i++) {
		cin >> indexT[i];
	}

	init_indexT(); // 남은 상위 노드를 채우는 과정

	for (int i = 1; i <= M + K; i++) {
		cin >> a >> b >> c;
		
		// 1이면 업데이트
		if (a == 1) update(b, c);
		else cout << sum(b, c) << "\n";
	}

	return 0;
}

// 배열 - 시간초과
//#include <iostream>
//
//using namespace std;
//
//int N, M, K, a, b;
//long long c;
//
//long long Data[1000002];
//
//int main() {
//	cin.tie(0);
//	ios::sync_with_stdio(0);
//
//	cin >> N >> M >> K;
//
//	for (int i = 1; i <= N; i++) {
//		cin >> Data[i];
//	}
//	for (int i = 1; i <= M + K; i++) {
//		cin >> a >> b >> c;
//		long long sum = 0;
//		// 바꾸기
//		if (a == 1) {
//			Data[b] = c;
//			continue;
//		}
//		// 출력
//		else {
//			while (b <= c) {
//				sum += Data[b++];
//			}
//		}
//
//		cout << sum << "\n";
//	}
//
//	return 0;
//}