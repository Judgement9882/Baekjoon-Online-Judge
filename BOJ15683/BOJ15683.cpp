// https://www.acmicpc.net/problem/15683

/*
	- Basic idea
	: 시간 제한을 고려하여 1~5 까지의 우선순위를 정했습니다.
	4방향을 다 감시하는 5를 먼저 고려하여 0을 최대한 제거하면 좋을 것 같아
	한번에 3개의 값을 저장할 수 있는 tuple<int, int, int> 를 설정하여
	1~5까지의 값과 x, y 값을 저장했습니다.

	그 뒤 내림차순 정렬을 이용해 5번 cctv를 먼저 고려할 수 있게끔 했습니다.
	1~4번 같은 경우, 0을 최대한 제거하는 방향으로 가기위해 
	0의 개수를 세는 noz 함수를 이용했고, noz 함수의 return으로 얻은
	그 방향에 대해 0을 제거하는 cztn 함수를 이용했습니다.

	해당 페이지에 있는 예제를 확인하고 제출을 했지만 오답이 나와
	반례를 찾지못하고 결국 풀이를 참조했습니다.

	- reference idea
	: 4가지의 방향을 4진법으로 생각하여 각각에 대한 모든 경우를 생각하는 방법으로
	진행했습니다. 만약 cctv의 개수가 k개라면 총 4^k 의 방법을 구하여 그 중 최소값을
	출력하는 방식입니다. 
*/


// 참조 전 풀이방식
/*
#include <bits/stdc++.h>
using namespace std;

int board[10][10];
int N, M;
vector<tuple<int, int, int>>v; // num, pos x , pos y

// detect the number of zero
int noz(int dir, int x, int y) {
	int cnt = 0;
	if (dir == 0) { // +x
		while (x <= M && x >= 1) {
			if (board[y][x] == 6) return cnt;
			if (board[y][x] == 0) cnt++;
			x++;
		}
		return cnt;
	}
	else if (dir == 1) { // +y
		while (y >= 1 && y <= N) {
			if (board[y][x] == 6) return cnt;
			if (board[y][x] == 0) cnt++;
			y--;
		}
		return cnt;
	}
	else if (dir == 2) { // -x
		while (x <= M && x >= 1) {
			if (board[y][x] == 6) return cnt;
			if (board[y][x] == 0) cnt++;
			x--;
		}
		return cnt;
	}
	else if (dir == 3) { // -y
		while (y >= 1 && y <= N) {
			if (board[y][x] == 6) return cnt;
			if (board[y][x] == 0) cnt++;
			y++;
		}
		return cnt;
	}
}


// change zero to number
void cztn(int dir, int x, int y) {
	if (dir == 0) { // +x
		while (x <= M && x >= 1) {
			if (board[y][x] == 6) return;
			if (board[y][x] == 0) board[y][x] = 9; // not # but easy to use
			x++;
		}
	}
	else if (dir == 1) { // +y
		while (y >= 1 && y <= N) {
			if (board[y][x] == 6) return;
			if (board[y][x] == 0) board[y][x] = 9; // not # but easy to use
			y--;
		}
	}
	else if (dir == 2) { // -x
		while (x <= M && x >= 1) {
			if (board[y][x] == 6) return;
			if (board[y][x] == 0) board[y][x] = 9; // not # but easy to use
			x--;
		}
	}
	else if (dir == 3) { // -y
		while (y >= 1 && y <= N) {
			if (board[y][x] == 6) return;
			if (board[y][x] == 0) board[y][x] = 9; // not # but easy to use
			y++;
		}
	}
}


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> board[i][j];
			if (board[i][j] > 0 && board[i][j] < 6) {
				v.push_back(make_tuple(board[i][j], j, i));
			}
		}
	}

	sort(v.begin(), v.end(), greater<>());
	for (int i = 0; i < v.size(); i++) {
		int max_num = 0;
		int max_index = 0;
		if (get<0>(v[i]) == 5) {
			for (int j = 0; j < 4; j++) {
				cztn(j, get<1>(v[i]), get<2>(v[i]));
			}
		}

		else if (get<0>(v[i]) == 4) {
			for (int j = 0; j < 4; j++) {
				int temp = noz(j, get<1>(v[i]), get<2>(v[i])) +
					noz((j + 1) % 4, get<1>(v[i]), get<2>(v[i])) +
					noz((j + 2) % 4, get<1>(v[i]), get<2>(v[i]));
				if (temp > max_num) {
					max_num = temp;
					max_index = j;
				}
			}
			for (int k = 0; k < 3; k++) {
				cztn((max_index + k) % 4, get<1>(v[i]), get<2>(v[i]));
			}
		}

		// 2, 3번 사이에 우선순위 정하기

		else if (get<0>(v[i]) == 3 || get<0>(v[i]) == 2) {


			for (int j = 0; j < 4; j++) {
				int temp = noz(j, get<1>(v[i]), get<2>(v[i])) + noz((j + 1) % 4, get<1>(v[i]), get<2>(v[i]));
				if (temp > max_num) {
					max_num = temp;
					max_index = j;
				}
			}
			for (int k = 0; k < 2; k++) {
				cztn((max_index + k) % 4, get<1>(v[i]), get<2>(v[i]));
			}
		}

		//else if (get<0>(v[i]) == 2) {
		//	for (int j = 0; j < 2; j++) {
		//		int temp = noz(j, get<1>(v[i]), get<2>(v[i])) + noz(j+2, get<1>(v[i]), get<2>(v[i]));
		//		if (temp > max_num) {
		//			max_num = temp;
		//			max_index = j;
		//		}
		//	}
		//	for (int k = 0; k < 3; k+=2) {
		//		cztn((max_index + k) % 4, get<1>(v[i]), get<2>(v[i]));
		//	}
		//}

		else if (get<0>(v[i]) == 1) {
			for (int j = 0; j < 4; j++) {
				int temp = noz(j, get<1>(v[i]), get<2>(v[i]));
				if (temp > max_num) {
					max_num = temp;
					max_index = j;
				}
			}
			cztn(max_index, get<1>(v[i]), get<2>(v[i]));
		}
	}

	int countzero = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (board[i][j] == 0) {
				countzero++;
			}
		}
	}
	cout << countzero;

	return 0;
}
*/

// 참조 후 풀이방식

#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int board1[10][10];
int board2[10][10];
int N, M;
vector<pair<int, int>> v; // pos x , pos y

// check boundary
bool cb(int x, int y) {
	return x < 0 || x >= N || y < 0 || y >= M;
}

// change zero to number
void cztn(int dir, int x, int y) {
	dir %= 4;
	while (1) {
		x += dx[dir]; // 해당 방향에 대한 연산
		y += dy[dir]; // 해당 방향에 대한 연산
		if (board2[x][y] == 6 || cb(x, y)) return; // 6을 만나거나 범위밖인경우 return
		if (board2[x][y] != 0) continue; // 0이 아닌경우(cctv인경우) continue
		board2[x][y] = 9; // 0을 임의의숫자 9로 바꿈.
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	int vbs = 0; // vehicle blind spot(사각지대)
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board1[i][j];
			if (board1[i][j] > 0 && board1[i][j] < 6) {
				v.push_back(make_pair(i, j));
			}
			if (board1[i][j] == 0) {
				vbs++;
			}
		}
	}
	
	for (int temp = 0; temp < (1 << (2 * v.size())); temp++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board2[i][j] = board1[i][j];
			}
		}

		int brute = temp;
		
		for (int i = 0; i < v.size(); i++) {
			int dir = brute % 4;
			brute /= 4;
			int x = v[i].X;
			int y = v[i].Y;
			if (board1[x][y] == 1) {
				cztn(dir, x, y);
			}

			else if (board1[x][y] == 2) {
				cztn(dir, x, y);
				cztn(dir + 2, x, y);
			}

			else if (board1[x][y] == 3) {
				cztn(dir, x, y);
				cztn(dir + 1, x, y);
			}

			else if (board1[x][y] == 4) {
				cztn(dir, x, y);
				cztn(dir + 1, x, y);
				cztn(dir + 2, x, y);
			}

			else if (board1[x][y] == 5) {
				cztn(dir, x, y);
				cztn(dir + 1, x, y);
				cztn(dir + 2, x, y);
				cztn(dir + 3, x, y);
			}
		}

		int tem_vbs = 0; // temporary vehicle blind spot
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board2[i][j] == 0) tem_vbs++;
			}
		}

		vbs = min(tem_vbs, vbs);
	}

	cout << vbs;

	return 0;
}