// https://www.acmicpc.net/problem/15873
/*
	한줄로 입력을 받아
	덧셈을 하는 문제
*/

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	string temp;
	cin >> temp;
	
	if (temp.size() == 2) {
		cout << (temp[0] - '0') + (temp[1] - '0');
	}
	else if (temp.size() == 3) {
		if (temp[1] == '0') cout << 10 + (temp[2] - '0');
		else cout << 10 + (temp[0] - '0');
	}
	else if (temp.size() == 4) cout << 20;
	
	return 0;
}