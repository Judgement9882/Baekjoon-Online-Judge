/*
	https://www.acmicpc.net/problem/1212

	8 to 2
*/

#include <iostream>
#include <string>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	string temp;
	cin >> temp;
	for (int i = 0; i < temp.length(); i++) {


		if (temp[i] == '0') {
			if (i == 0) {
				cout << "0";
				break;
			}
			cout << "000";
		}
		else if (temp[i] == '1') {
			if (i == 0) {
				cout << "1";
			}
			else cout << "001";
		}
		else if (temp[i] == '2') {
			if (i == 0) {
				cout << "10";
			}
			else cout << "010";
		}
		else if (temp[i] == '3') {
			if (i == 0) {
				cout << "11";
			}
			else cout << "011";
		}
		else if (temp[i] == '4') cout << "100";
		else if (temp[i] == '5') cout << "101";
		else if (temp[i] == '6') cout << "110";
		else if (temp[i] == '7') cout << "111";
	}
	

	return 0;
}



