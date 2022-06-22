/*
	https://www.acmicpc.net/problem/5524
	
	입실관리
*/

#include <iostream>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N;
	string name;
	cin >> N;
	while (N--) {
		cin >> name;
		for (int i = 0; i < name.length(); i++) {
			if (name[i] >= 65 && name[i] <= 90) name[i] += 32;
		}
		cout << name << "\n";
	}

	
	return 0;
}
