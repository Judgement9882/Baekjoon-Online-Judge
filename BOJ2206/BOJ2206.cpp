// https://www.acmicpc.net/problem/2206

/*
	0�� 1�� �̷���� N x M ����.
	0�� �̵�����, 1�� �̵� �Ұ���
	(1,1) ��� (N,M) �����ϴµ� �ɸ��� �ִܰ��
	�� 1�� �ѹ� �μ� �� ����.

	- ù��° �õ� :
	��Ʈ��ŷ���� DFS ����. ������ �� �������� ����.
	�ð����⵵�� �׷��� ����� ���Ƽ� DFS�� ����.

	- �ι�° �õ� :
	BFS�� ����. dist�� 2���� �迭�� ��� ����.
	but flag�� �ܼ� ������ ��� �Ἥ �����Ѱ����� ����.
	

	��Ǯ� ������ �ڵ� ��ó : 
	https://rebas.kr/658
*/

#include <bits/stdc++.h>

using namespace std;

// ť�� ������ ��. ��ǥ�� ���� �վ����� �����ϴ� flag
struct board_que {
	int y, x, flag;
};

int board[1002][1002];
int dist[1002][1002][2];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int N, M;

int bfs() {
	queue<board_que> Q;

	// 0,0 ����
	Q.push({ 0, 0, 0 });
	dist[0][0][0] = 1;

	while (!Q.empty()) {
		board_que cur = Q.front();
		Q.pop();

		// N, M�� �������� �� return
		if (cur.y == N - 1 && cur.x == M - 1) return dist[cur.y][cur.x][cur.flag];

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cur.x;
			int ny = dy[i] + cur.y;

			if (nx < 0 || nx >= M || ny < 0 || ny >= N || dist[ny][nx][cur.flag]) continue;
			if (board[ny][nx] == 0) {
				dist[ny][nx][cur.flag] = dist[cur.y][cur.x][cur.flag] + 1;
				Q.push({ ny, nx, cur.flag });
			}

			// 1�� �����µ� ���� ���� �ȶ��� ���
			if (board[ny][nx] == 1 && cur.flag == 0) {
				dist[ny][nx][1] = dist[cur.y][cur.x][cur.flag] + 1;
				Q.push({ ny, nx, 1 });
			}
		}
	}
	// N, M �� ���� ������ �� -1 return
	return -1;
}

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		for (int j = 0; j < M; j++) {
			board[i][j] = temp[j] - '0';
		}
	}

	cout << bfs();

	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < M; j++) {
	//		cout << dist[i][j][1] << "  ";
	//	}
	//	cout << "\n";
	//}

	return 0;
}


// https://www.acmicpc.net/problem/2206

/*
	0�� 1�� �̷���� N x M ����.
	0�� �̵�����, 1�� �̵� �Ұ���
	(1,1) ��� (N,M) �����ϴµ� �ɸ��� �ִܰ��
	�� 1�� �ѹ� �μ� �� ����.







*/


// dfs �õ� �ڵ�.

//#include <bits/stdc++.h>
//
//#define Y first
//#define X second
//
//using namespace std;
//
//int board[1002][1002];
//int dist[1002][1002];
//
//int dx[4] = { 1, 0, -1, 0 };
//int dy[4] = { 0, 1, 0, -1 };
//
//int N, M;
//int wall_flag;
//int cnt = 1;
//
//void dfs(int y, int x) {
//	dist[y][x] = cnt;
//	cnt++;
//
//	for (int i = 0; i < 4; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//
//		// ���� ��Ż
//		if (ny <= 0 || ny > N || nx <= 0 || nx > M || dist[ny][nx] >= 0) continue;
//
//		// 1�� ������ ��
//		if (board[ny][nx] == 1) {
//			// ���� ���� �� �μ� ���
//			if (wall_flag == 0) {
//				board[ny][nx] = 0;
//				wall_flag = 1;
//
//				dfs(ny, nx);
//
//				cnt--;
//				board[ny][nx] = 1;
//				wall_flag = 0;
//				continue;
//			}
//
//			// �̹� ���� �μ� ���
//			else continue;
//		}
//
//		// 0�� ������ ��
//		dfs(ny, nx);
//		cnt--;
//	}
//}
//
//int main() {
//
//	cin.tie(0);
//	ios::sync_with_stdio(0);
//
//	cin >> N >> M;
//	for (int i = 1; i <= N; i++) {
//		string temp;
//		cin >> temp;
//		for (int j = 1; j <= M; j++) {
//			board[i][j] = temp[j - 1] - '0';
//			dist[i][j] = -1;
//		}
//	}
//
//
//	dfs(1, 1);
//
//	//for (int i = 1; i <= N; i++) {
//	//	for (int j = 1; j <= M; j++) {
//	//		cout << dist[i][j] << "  "; 
//	//	}
//	//	cout << '\n';
//	//}
//
//	cout << dist[N][M];
//
//	return 0;
//}