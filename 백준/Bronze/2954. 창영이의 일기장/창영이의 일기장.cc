/*
	https://www.acmicpc.net/problem/2954

	창영 일기장
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<char> origin;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp;
	getline(cin, temp);
	
	for (int i = 0; i < temp.length(); i++) {
		origin.push_back(temp[i]);
		if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
			i += 2;
		}
	}

	for (auto k : origin) {
		cout << k;
	}

	return 0;
}



