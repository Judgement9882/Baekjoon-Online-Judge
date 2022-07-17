/*
	https://www.acmicpc.net/problem/1159

	농구
*/

#include <iostream>
#include <string>
using namespace std;

int name[30];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	string temp;
	int N;
	cin >> N;
	while (N--) {
		cin >> temp;
		name[temp[0] - 'a']++;
	}
	int flag = 0;
	for (int i = 0; i < 30; i++) {
		
		if (name[i] >= 5) {
			flag = 1;
			cout << char(i + 'a');
		}
	}
	if (flag == 0) {
		cout << "PREDAJA";
	}

	return 0;
}



