/*
	https://www.acmicpc.net/problem/9086

	문자열
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N;
	string S;
	cin >> N;
	while (N--) {
		cin >> S;
		cout << S[0] << S[S.length()-1] << "\n";
	}

	return 0;
}