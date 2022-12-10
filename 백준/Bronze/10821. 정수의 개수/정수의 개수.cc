#include <iostream>
#include <string>
#include <algorithm>
using namespace std;



int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string temp; cin >> temp;
	int cnt = 1;
	for (int i = 0; i < temp.length(); i++) {
		if (temp[i] == ',') cnt++;
	}
	
	cout << cnt;


	return 0;
}