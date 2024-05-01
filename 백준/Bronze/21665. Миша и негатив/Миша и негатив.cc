#include <iostream>
#include <string>
using namespace std;
char board[101][101];
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n, m;
	cin >> n >> m;
	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		for (int j = 0; j < m; j++) {
			board[i][j] = str[j];
		}
	}
	int ans = 0;
	for (int i = 0; i < n; i++) {
		cin >> str;
		for (int j = 0; j < m; j++) {
			if (board[i][j] == str[j]) ans++;
		}
	}
	cout << ans;
	return 0;
}