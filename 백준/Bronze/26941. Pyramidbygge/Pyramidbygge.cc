#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	int tall = 1, floor = 3;
	while (1) {
		if (N > floor * floor) {
			N -= floor * floor;
			tall++;
			floor += 2;
			continue;
		}
		break;
	}
	cout << tall;
	

	return 0;
}