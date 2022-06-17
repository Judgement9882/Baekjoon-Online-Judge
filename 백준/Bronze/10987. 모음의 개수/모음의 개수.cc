/*
	https://www.acmicpc.net/problem/10987
	
	모음 개수
*/

#include <iostream>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	char moum[5] = { 'a', 'e', 'i', 'o', 'u' };

	string temp;
	cin >> temp;
	int cnt = 0;
	for (int i = 0; i < temp.length(); i++) {
		for (int j = 0; j < 5; j++) {
			if (temp[i] == moum[j]) {
				cnt++;
				break;
			}
		}
	}
	cout << cnt;
	return 0;
}
