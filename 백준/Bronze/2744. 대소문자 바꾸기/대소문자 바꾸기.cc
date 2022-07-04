/*
	https://www.acmicpc.net/problem/2744

	대소문자
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string S;
	cin >> S;
	for (int i = 0; i < S.length(); i++) {
		if (S[i] >= 'A' && S[i] <= 'Z') {
			S[i] += 32;
		}
		else {
			S[i] -= 32;
		}
	}
	cout << S;
	return 0;
}