#include <iostream>
#include <unordered_map>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	unordered_map<string, string> map;
	while (N--) {
		string key, eq, val;
		cin >> key >> eq >> val;
		map.insert({ key, val });
	}
	int T; cin >> T;
	while (T--) {
		int n; cin >> n;
		while (n--) {
			string keyword; cin >> keyword;
			for (auto elem : map) {
				if (elem.first == keyword) cout << elem.second << " ";
			}
		}
		cout << "\n";
	}
	
	return 0;
}