/*
	https://www.acmicpc.net/problem/14502

	연구소
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int board[10][10];
int board_v2[10][10];
bool isused[10][10];
vector<pair<int, int> > virus_pos;

int N, M, max_cnt = 0;

// 새로운 보드에 기존 보드 카피
void copy_board() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			board_v2[i][j] = board[i][j];
		}
	}
}

// 안전 영역 크기 구하기 (0 세기)
int solve() {
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board_v2[i][j] == 0) cnt++;
			//cout << board_v2[i][j] << " ";
		}
		//cout << "\n";
	}
	return cnt;
}


void func(int k) {

	if (k == 3) {

		// 사용할 v2 보드에 카피
		copy_board();

		// bfs 진행
		queue<pair<int, int>> q;
		for (int m = 0; m < virus_pos.size(); m++) {
			q.push(virus_pos[m]);
		}

		while (!q.empty()) {
			pair<int, int> cur = q.front(); q.pop();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur.first;
				int ny = dy[dir] + cur.second;

				// 범위 이탈
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				// 바이러스이거나 벽일때
				if (board_v2[nx][ny] == 2 || board_v2[nx][ny] == 1) continue;

				board_v2[nx][ny] = 2;
				q.push({ nx, ny });
			}
		}

		max_cnt = max(max_cnt, solve());

		//cout << max_cnt << "\n";
		

		return;
	}
	
	// 모든 좌표에 대하여
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (isused[i][j] == 0 && board[i][j] == 0) {
				isused[i][j] = 1;
				board[i][j] = 1;
				func(k + 1);
				board[i][j] = 0;
				isused[i][j] = 0;
			}
		}
	}
}



int main()
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	fill(isused[0], isused[0] + 10 * 10, 0);

	cin >> N >> M;
	for(int i = 0 ; i < N ; i++){
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			
			if (board[i][j] == 2) {
				virus_pos.push_back({ i, j });
			}
		}
	}
	
	func(0);
	cout << max_cnt;
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
