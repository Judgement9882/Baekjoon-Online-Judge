#include <bits/stdc++.h>

using namespace std;

#define length 3074
char board[length][length * 2];

char star_set[][6]=
{ "  *  ", 
  " * * ", 
  "*****" };

void star(int y, int x, int n) {
	if (n == 1) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				board[y+i][x+j] = star_set[i][j];
			}
		}
		return;
	}
	star(y, x + 3 * n / 2, n / 2);
	star(y + 3 * n / 2, x, n / 2);
	star(y + 3 * n / 2, x + 3 * n, n / 2);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	star(0, 0, N/3);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 2 * N - 1; j++) {
			if (board[i][j] == '*') {
				cout << '*';
			}
			else {
				cout << ' ';
			}
		}
		cout << "\n";
	}
	return 0;
}

