/*
	https://www.acmicpc.net/problem/3059

	등장하지 않은 문자의 합
*/

#include <iostream>

using namespace std;

int eng[26];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	while (N--){
		for (int i = 0; i < 26; i++) {
			eng[i] = i + 65;
		}
		string temp;
		cin >> temp;
		for (int i = 0; i < temp.length(); i++) {
			eng[temp[i] - 'A'] = 0;
		}
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += eng[i];
		}
		cout << sum << "\n";
	}

	return 0;
}



