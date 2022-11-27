#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int board[132][132];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	while (N--) {
		int a, b; cin >> b >> a;
		
		for (int i = a; i < a + 10; i++) {
			for (int j = b; j < b + 10; j++) {
				board[i][j] = 1;
			}
		}
	}
	int cnt = 0;
	for (int i = 1; i <= 100; i++) {
		for (int j = 1; j <= 100; j++) {
			if (board[i][j] == 1) cnt++;
			//cout << board[i][j] << " ";
		}
		//cout << "\n";
	}
	cout << cnt;
	return 0;
}