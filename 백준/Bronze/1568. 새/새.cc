#include <iostream>
#include <string>
#include <algorithm>
using namespace std;



int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	
	int minus_num = 1;
	int ans = 0;
	while (N > 0) {
		if (N < minus_num) {
			minus_num = 1;
		}
		N -= minus_num++;
		ans++;

	}
	cout << ans;


	return 0;
}