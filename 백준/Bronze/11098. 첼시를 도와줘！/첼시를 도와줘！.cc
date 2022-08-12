/*
	https://www.acmicpc.net/problem/11098

	첼시를 도와줘
*/

#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	while (T--) {
		int n;
		cin >> n;

		int max_num = -999;
		string best_player = "boj11098";
		while (n--) {
			int num;
			string name;
			cin >> num >> name;
			
			if (num >= max_num) {
				max_num = num;
				best_player = name;
			}
		}

		cout << best_player << "\n";
	}


	return 0;
}



