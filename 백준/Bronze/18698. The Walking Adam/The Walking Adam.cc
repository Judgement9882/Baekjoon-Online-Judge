#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	
	int T; cin >> T;
	while (T--) {
		string str; cin >> str;
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == 'U') temp++;
			else break;
		}
		cout << temp << "\n";
	}
	
	return 0;
}