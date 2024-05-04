#include <iostream>
#include <string>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string str;
	cin >> str;
	int i = 0;
	while(i < str.length()){
		cout << str[i];
		i += str[i] - 'A' + 1;
	}
	return 0;
}