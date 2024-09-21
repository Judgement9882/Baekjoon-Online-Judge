#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int T; cin >> T;
	while (T--) {
		string str; cin >> str;
		int a = 0, b = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (str[i] == 'a') a++;
			else b++;
		}
		cout << min(a, b) << "\n";
	}
	
	
	return 0;
}