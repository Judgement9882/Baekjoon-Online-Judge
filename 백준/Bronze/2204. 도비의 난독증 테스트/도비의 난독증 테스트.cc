#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<pair<string, int>> words;
string realWord[1002];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	while (1) {
		int N; cin >> N;
		if (N == 0) break;

		for (int i = 0; i < N; i++) {
			string temp; cin >> temp;
			realWord[i] = temp;

			for (int j = 0; j < temp.length(); j++) {
				temp[j] = tolower(temp[j]);
			}

			words.push_back({ temp, i });
		}

		sort(words.begin(), words.end());
		
		cout << realWord[words[0].second] << "\n";

		while (!words.empty()) words.pop_back();
	}
	return 0;
}