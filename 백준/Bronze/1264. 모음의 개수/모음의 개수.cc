/*
	https://www.acmicpc.net/problem/2468

	안전 영역
*/

#include <iostream>
#include <string>

using namespace std;

int cnt;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	while (1) {
		string temp;
		getline(cin, temp);
		if (temp == "#") break;

		cnt = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'o' || temp[i] == 'u' || temp[i] == 'i' || temp[i] == 'A' || temp[i] == 'E' || temp[i] == 'O' || temp[i] == 'U' || temp[i] == 'I') cnt++;
		}
		cout << cnt << "\n";
	}

	return 0;
}