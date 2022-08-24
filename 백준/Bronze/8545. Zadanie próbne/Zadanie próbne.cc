/*
	https://www.acmicpc.net/problem/8545

	Zadanie próbne
*/

#include <iostream>
#include <algorithm>


using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp; cin >> temp;
	swap(temp[0], temp[2]);
	cout << temp;


	return 0;
}



