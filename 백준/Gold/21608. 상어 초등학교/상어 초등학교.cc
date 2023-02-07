/*
	https://www.acmicpc.net/problem/21608

	상어초등학교
	출처 : https://www.youtube.com/watch?v=bf_4nGviJ7k&ab_channel=na982
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int board[22][22];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

struct Student {
	int num;
	int fri[4]; // 선호 친구
	int x, y; // 위치
};

vector<Student> st;

int getPoint(int x, int y, int index) {
	int point = 0;
	for (int dir = 0; dir < 4; dir++) {
		int nx = dx[dir] + x;
		int ny = dy[dir] + y;

		if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

		// 비어있으면 점수 +1
		if (board[nx][ny] == 0) {
			point++;
		}
		// 있는데, 만약 호감인물이라면 점수를 더 더함(우선순위가 더 높음)
		else {
			for (int f = 0; f < 4; f++) {
				if (board[nx][ny] == st[index].fri[f]) point += 10;
			}
		}
	}
	return point;
}

void setStudent(int x, int y, int index) {
	// 위치정보 갱신
	st[index].x = x;
	st[index].y = y;

	// 숫자 넣기
	board[x][y] = st[index].num;
}

int calcPoint(int index){
	int point = 0;

	// 현재 위치
	int x = st[index].x;
	int y = st[index].y;

	for (int dir = 0; dir < 4; dir++) {
		int nx = dx[dir] + x;
		int ny = dy[dir] + y;
		
		if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
		for(int f = 0 ; f < 4; f++){
			if (board[nx][ny] == st[index].fri[f]) {
				// 처음일 경우
				if (point == 0) point++;
				// 2이상인 경우
				else {
					point *= 10;
				}
			}
		}	
	}
	return point;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N;

	// init
	fill(board[0], board[0] + 22 * 22, 0);

	for (int i = 0; i < N * N; i++) {
		int n, f, s, t, h;
		cin >> n >> f >> s >> t >> h;
		st.push_back({ n, f, s, t, h });
	}

	for (int i = 0; i < N * N; i++) {
		// 임시위치와 점수
		int temp_x = -1, temp_y = -1, point = -1;
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				// 보드가 비어있어야 배치를 시킬 수 있음
				if (board[x][y] == 0) {
					int curPoint = getPoint(x, y, i);

					// point 보다 curPoint가 더 크다면 위치시킬 수 있는 후보지임
					if (point < curPoint) {
						temp_x = x; temp_y = y; point = curPoint;
					}
				}
			}
		}

		setStudent(temp_x, temp_y, i);

	}
		
	int ret = 0;
	for (int i = 0; i < N * N; i++) {
		ret += calcPoint(i);
	}

	cout << ret << "\n";

	
	
	return 0;
}
