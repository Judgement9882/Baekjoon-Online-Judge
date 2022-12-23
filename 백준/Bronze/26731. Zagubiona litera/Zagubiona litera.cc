#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

bool board[30];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string temp; cin >> temp;
	for (int i = 0; i < 25; i++) {
		board[temp[i] - 'A'] = true;
	}
	for (int i = 0; i < 26; i++) {
		if (board[i] == false) {
			cout << char(i+65);
		}
	}

	return 0;
}