#include <iostream>
#include <string>
#include <algorithm>
using namespace std;



int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	int cnt = 0;
	if (N > 198) cout << "0";
	else {
		for (int i = 0; i < 100; i++) {
			if (N - i <= 99) {
				cnt++;
			}
		}

		cout << cnt;
	}
	


	return 0;
}