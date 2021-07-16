// https://www.acmicpc.net/problem/15683

/*
	- Basic idea
	: �ð� ������ ����Ͽ� 1~5 ������ �켱������ ���߽��ϴ�.
	4������ �� �����ϴ� 5�� ���� ����Ͽ� 0�� �ִ��� �����ϸ� ���� �� ����
	�ѹ��� 3���� ���� ������ �� �ִ� tuple<int, int, int> �� �����Ͽ�
	1~5������ ���� x, y ���� �����߽��ϴ�.

	�� �� �������� ������ �̿��� 5�� cctv�� ���� ����� �� �ְԲ� �߽��ϴ�.
	1~4�� ���� ���, 0�� �ִ��� �����ϴ� �������� �������� 
	0�� ������ ���� noz �Լ��� �̿��߰�, noz �Լ��� return���� ����
	�� ���⿡ ���� 0�� �����ϴ� cztn �Լ��� �̿��߽��ϴ�.

	�ش� �������� �ִ� ������ Ȯ���ϰ� ������ ������ ������ ����
	�ݷʸ� ã�����ϰ� �ᱹ Ǯ�̸� �����߽��ϴ�.

	- reference idea
	: 4������ ������ 4�������� �����Ͽ� ������ ���� ��� ��츦 �����ϴ� �������
	�����߽��ϴ�. ���� cctv�� ������ k����� �� 4^k �� ����� ���Ͽ� �� �� �ּҰ���
	����ϴ� ����Դϴ�. 
*/


// ���� �� Ǯ�̹��
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

		// 2, 3�� ���̿� �켱���� ���ϱ�

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

// ���� �� Ǯ�̹��

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
		x += dx[dir]; // �ش� ���⿡ ���� ����
		y += dy[dir]; // �ش� ���⿡ ���� ����
		if (board2[x][y] == 6 || cb(x, y)) return; // 6�� �����ų� �������ΰ�� return
		if (board2[x][y] != 0) continue; // 0�� �ƴѰ��(cctv�ΰ��) continue
		board2[x][y] = 9; // 0�� �����Ǽ��� 9�� �ٲ�.
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	int vbs = 0; // vehicle blind spot(�簢����)
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