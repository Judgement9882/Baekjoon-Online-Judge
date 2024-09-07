#include <iostream>
#include <string>
using namespace std;
char S[101];
int cindex = 0;

bool checkKeyword(string keyword) {
	int keywordLen = keyword.length();
	for (int i = 0; i < cindex - keywordLen + 1; i++) {
		bool temp = true;
		for (int j = 0; j < keywordLen; j++) {
			if (keyword[j] != S[i+j]) temp = false;
		}
		if (temp) {
			return true;
		}
	}
	return false;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	string str; cin >> str;
	
	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= '0' && str[i] <= '9') continue;
		S[cindex++] = str[i];
	}
	
	string keyword; cin >> keyword;
	cout << (checkKeyword(keyword) ? 1 : 0);

	return 0;
}