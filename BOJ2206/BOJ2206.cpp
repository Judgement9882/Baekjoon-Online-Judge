// https://www.acmicpc.net/problem/2206

/*
	0과 1로 이루어진 N x M 보드.
	0은 이동가능, 1은 이동 불가능
	(1,1) 출발 (N,M) 도착하는데 걸리는 최단경로
	단 1은 한번 부술 수 있음.

	- 첫번째 시도 :
	백트래킹으로 DFS 구현. 예제는 잘 나왔으나 실패.
	시간복잡도도 그렇고 힘들거 같아서 DFS는 포기.

	- 두번째 시도 :
	BFS로 구현. dist를 2차원 배열로 잡고 구현.
	but flag를 단순 변수로 잡고 써서 실패한것으로 보임.
	

	못풀어서 참고한 코드 출처 : 
	https://rebas.kr/658
*/

#include <bits/stdc++.h>

using namespace std;

// 큐에 저장할 것. 좌표와 벽을 뚫었는지 저장하는 flag
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

	// 0,0 삽입
	Q.push({ 0, 0, 0 });
	dist[0][0][0] = 1;

	while (!Q.empty()) {
		board_que cur = Q.front();
		Q.pop();

		// N, M에 도착했을 때 return
		if (cur.y == N - 1 && cur.x == M - 1) return dist[cur.y][cur.x][cur.flag];

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cur.x;
			int ny = dy[i] + cur.y;

			if (nx < 0 || nx >= M || ny < 0 || ny >= N || dist[ny][nx][cur.flag]) continue;
			if (board[ny][nx] == 0) {
				dist[ny][nx][cur.flag] = dist[cur.y][cur.x][cur.flag] + 1;
				Q.push({ ny, nx, cur.flag });
			}

			// 1을 만났는데 아직 벽을 안뚫은 경우
			if (board[ny][nx] == 1 && cur.flag == 0) {
				dist[ny][nx][1] = dist[cur.y][cur.x][cur.flag] + 1;
				Q.push({ ny, nx, 1 });
			}
		}
	}
	// N, M 에 도착 못했을 때 -1 return
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
	0과 1로 이루어진 N x M 보드.
	0은 이동가능, 1은 이동 불가능
	(1,1) 출발 (N,M) 도착하는데 걸리는 최단경로
	단 1은 한번 부술 수 있음.







*/


// dfs 시도 코드.

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
//		// 범위 이탈
//		if (ny <= 0 || ny > N || nx <= 0 || nx > M || dist[ny][nx] >= 0) continue;
//
//		// 1을 만났을 때
//		if (board[ny][nx] == 1) {
//			// 아직 벽을 안 부순 경우
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
//			// 이미 벽을 부순 경우
//			else continue;
//		}
//
//		// 0을 만났을 때
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