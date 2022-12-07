#include <iostream>
#include <string>
#include <algorithm>
using namespace std;



int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	long long N; cin >> N;
	long long cnt = 1, sum = 0;
	while (1) {
		sum += cnt++;
		if (sum == N) {
			// 같을경우 
			cout << cnt-1;
			break;
		}
		else if (sum > N) {
			// 합이 더 클 경우
			cout << cnt - 2;
			break;
		}
	}


	return 0;
}