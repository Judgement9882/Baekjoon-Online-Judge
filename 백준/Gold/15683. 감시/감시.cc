/*
	https://www.acmicpc.net/problem/15683

	감시
*/

#include <iostream>
#include <vector>
#include <utility>
#include <cmath>

using namespace std;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board[10][10];
int test_board[10][10];
int N, M;

vector<pair<int, int>> cctv;

// 시작점을 받아 해당 방향으로 직진하는 함수
void straight(int dir, int x, int y) {
	int nx = x + dx[dir];
	int ny = y + dy[dir];

	while (!(nx < 0 || ny < 0 || nx >= N || ny >= M)) {
		int temp = test_board[nx][ny];

		// 벽을 만나면 종료
		if (temp == 6) break;

		// 이미 방문했거나 cctv면 패스하고 0일경우에만 입력
		if (temp == 0) {
			test_board[nx][ny] = 8; // #대신 8로 사용
		}
		nx += dx[dir];
		ny += dy[dir];
	}
}


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if ((board[i][j] != 0) && (board[i][j] != 6)) {
				cctv.push_back({i, j});
			}
		}
	}
	int cnt = 0, min_cnt = 9999;
	// 최악의 경우 4^7 = 2^(2*7) 번의 경우의 수를 따져야함
	// 7은 cctv의 수
	for (int k = 0; k < 1 << (2 * cctv.size()); k++) {
		cnt = 0;
		// 테스트 보드에 동일한 환경 구성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				test_board[i][j] = board[i][j];
			}
		}

		// 모든 경우의 수를 따짐. 각각의 cctv는 네 방향의 경우의 수를 따질 수 있으므로
		// k를 4진법으로 생각하면 k의 0번째 자리의 수를 파악하고 (k%4)
		// k를 4로 나누면 right shift가 일어나므로 다시 0번째 자리수를 파악할 수 있다(k%4)
		int total_num = k;

		for (int i = 0; i < cctv.size(); i++) {
			if (board[cctv[i].first][cctv[i].second] == 1) {
				int dir = total_num % 4;
				total_num /= 4;

				straight(dir, cctv[i].first, cctv[i].second);
			}
			else if (board[cctv[i].first][cctv[i].second] == 2) {
				int dir = total_num % 4;
				total_num /= 4;

				straight(dir, cctv[i].first, cctv[i].second);
				straight((dir+2)%4, cctv[i].first, cctv[i].second);
			}
			else if (board[cctv[i].first][cctv[i].second] == 3) {
				int dir = total_num % 4;
				total_num /= 4;
				straight(dir, cctv[i].first, cctv[i].second);
				straight((dir+1)%4, cctv[i].first, cctv[i].second);
			}
			else if (board[cctv[i].first][cctv[i].second] == 4) {
				int dir = total_num % 4;
				total_num /= 4;
				straight(dir, cctv[i].first, cctv[i].second);
				straight((dir + 1) % 4, cctv[i].first, cctv[i].second);
				straight((dir + 2) % 4, cctv[i].first, cctv[i].second);
			}
			else if (board[cctv[i].first][cctv[i].second] == 5) {
				int dir = total_num % 4;
				total_num /= 4;
				straight(dir, cctv[i].first, cctv[i].second);
				straight((dir + 1) % 4, cctv[i].first, cctv[i].second);
				straight((dir + 2) % 4, cctv[i].first, cctv[i].second);
				straight((dir + 3) % 4, cctv[i].first, cctv[i].second);
			}
		}
		//cout << "test=============\n";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				//cout << test_board[i][j] << " ";
				
				if (test_board[i][j] == 0) {
					cnt++;
				}
			}
			//cout << "\n";
		}
		//cout << "test=============\n";
		min_cnt = min(min_cnt, cnt);
	}

	cout << min_cnt;
	return 0;
}



