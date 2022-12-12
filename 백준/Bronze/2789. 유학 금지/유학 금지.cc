#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string temp; cin >> temp;
	string univ = "CAMBRIDGE";
	vector<char> new_univ;
	for (int i = 0; i < temp.length(); i++) {
		int flag = 0;
		for (int j = 0; j < univ.length(); j++) {
			if (temp[i] == univ[j]) flag = 1;
		}
		if (!flag) {
			new_univ.push_back(temp[i]);
		}
	}
	for (int i = 0; i < new_univ.size(); i++) {
		cout << new_univ[i];
	}


	return 0;
}