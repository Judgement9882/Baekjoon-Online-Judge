/*
	https://www.acmicpc.net/problem/1236

	성 지키기
*/

#include <iostream>
#include <algorithm>
using namespace std;

char board[52][52];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	cin >> N >> M;
	
	int row_cnt = 0;
	int column_cnt = 0;

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		int flag = 0;
		for (int j = 0; j < M; j++) {
			board[i][j] = temp[j];
			if (temp[j] == 'X') flag = 1;
		}
		if (!flag) row_cnt++;
	}

	for (int j = 0; j < M; j++) {
		int flag = 0;
		for (int i = 0; i < N; i++) {
			if (board[i][j] == 'X') flag = 1;
		}
		if (!flag) column_cnt++;
	}
	
	cout << max(row_cnt, column_cnt);

	return 0;
}



