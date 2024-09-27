#include <bits/stdc++.h>

using namespace std;

int mix(int num, int order) {
	if (order == 0) {
		if (num == 1) return 2;
		if (num == 2) return 1;
	}
	else if (order == 1) {
		if (num == 2) return 3;
		if (num == 3) return 2;
	}
	else if (order == 2) {
		if (num == 1) return 3;
		if (num == 3) return 1;
	}
	return num;
}

int main() {
	cin.tie(0); 
    ios::sync_with_stdio(0);
    
	string str; cin >> str;
    
	int ans = 1;
	for (int i = 0; i < str.length(); i++) {
		ans = mix(ans, str[i] - 'A');
	}
    
	cout << ans;
	return 0;
}