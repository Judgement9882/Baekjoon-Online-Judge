#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N = 4;
	int sum = 0;
	int max_num = -99999;
	while (N--) {
		int in, out; cin >> in >> out;
		sum += out - in;
		max_num = max(sum, max_num);
	}
	cout << max_num;
	return 0;
}