#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int ans, N;
char opt;

void cal() {
	if (opt == '+') {
		ans += N;
	}
	else if (opt == '-') {
		ans -= N;
	}
	else if (opt == '*'){
		ans *= N;
	}
	else {
		ans /= N;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> ans;
	
	while (1) {
		cin >> opt;
		if (opt == '=') {
			break;
		}
		
		cin >> N;
		cal();
	}
	cout << ans;


	return 0;
}