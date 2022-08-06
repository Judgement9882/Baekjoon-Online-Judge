/*
	https://www.acmicpc.net/problem/4470

	줄번호
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	cin.ignore();
	string temp;
	
	for(int i = 1 ; i <= T ; i++){
		getline(cin, temp);
		cout << i << ". " << temp << "\n";
	
	}
	
	return 0;
}



