/*
	https://www.acmicpc.net/problem/2145

	숫자놀이
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp;
	while (1) {
		cin >> temp;
		if (temp == "0") break;
		if (temp.length() == 1) {
			cout << temp << "\n";
			continue;
		}

		int cnt = 0;
		while (temp.length() > 1) {
			cnt = 0;
			for (int i = 0; i < temp.length(); i++) {
				cnt += temp[i] - '0';
			}

			temp = to_string(cnt);
		}

		cout << cnt << "\n";
	}


	return 0;
}



