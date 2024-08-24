#include <iostream>
using namespace std;
char board[4][4];

void light(int index, int num) {
	if (num == 9) {
		board[0][index] = '*';
		board[3][index] = '*';
	}
	else if (num == 8) {
		board[0][index] = '*';
	}
	else if (num == 7) {
		board[1][index] = '*';
		board[2][index] = '*';
		board[3][index] = '*';
	}
	else if (num == 6) {
		board[1][index] = '*';
		board[2][index] = '*';
	}
	else if (num == 5) {
		board[1][index] = '*';
		board[3][index] = '*';
	}
	else if (num == 4) {
		board[1][index] = '*';
	}
	else if (num == 3) {
		board[2][index] = '*';
		board[3][index] = '*';
	}
	else if (num == 2) {
		board[2][index] = '*';
	}
	else if (num == 1) {
		board[3][index] = '*';
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int time; cin >> time;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			board[i][j] = '.';
		}
	}
	light(0, time / 1000);
	time %= 1000;
	light(1, time / 100);
	time %= 100;
	light(2, time / 10);
	time %= 10;
	light(3, time );
	
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 2; j++) {
			cout << board[i][j] << " ";
		}
		cout << "  ";
		for (int j = 2; j < 3; j++) {
			cout << board[i][j] << " ";
		}
		cout << board[i][3];
		cout << "\n";
	}


	return 0;
}