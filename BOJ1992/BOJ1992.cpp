#include <bits/stdc++.h>

using namespace std;

int N;
bool board[70][70];
void quad(int y, int x, int n) {
	if (n == 0) {
		cout << board[y][x];
		return;
	}

	bool flag0 = true;
	bool flag1 = true;

	for (int i = y; i < y + n; i++) {
		for (int j = x; j < x + n; j++) {
			if (board[i][j] == 1) {
				flag0 = false;
			}
			else {
				flag1 = false;
			}

			if (flag0 == false && flag1 == false) {
				break;
			}
		}

		if (flag0 == false && flag1 == false) {
			break;
		}
	}

	if (flag0) { // 모두 0
		cout << 0;
	}
	else if (flag1) { // 모두 1
		cout << 1;
	}
	else { // 같지않을때는 분리해서 진행.
		cout << "("; 
		quad(y, x, n / 2); // 좌상
		quad(y, x+n/2, n / 2); // 우상
		quad(y+n/2, x, n / 2); // 좌하
		quad(y+n/2, x+n/2, n / 2); // 우하
		cout << ")";
	}
	return;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;

		for (int j = 0; j < N; j++) {
			board[i][j] = s[j] - '0';
		}
	}

	quad(0, 0, N);
	cout << "\n";
	return 0;
}