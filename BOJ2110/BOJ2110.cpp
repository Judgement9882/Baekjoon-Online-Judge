#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	// I/O speed management
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	int N, C;
	cin >> N >> C;
	vector<int> house;
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		house.push_back(a);
	}

	sort(house.begin(), house.end());

	// assume that house[0] start
	
	int lowH = 1;
	int highH = 1000000000;
	
	while (highH > lowH+1) {
		int cnt = 1;
		
		// mid = first + end / 2
		int mid = (lowH + highH) / 2;
		int last = house[0];
		for (int i = 1; i < N; i++) {
			if (house[i] - last >= mid) {
				cnt++;
				last = house[i];
			}
		}

		// if cnt is smaller than C
		// -> mid is too big!
		// so we should decrease highH
		if (cnt < C) {
			highH = mid;
		}

		// if cnt is bigger than C
		// -> mid is too small!
		// so we should increase lowH
		else {
			lowH = mid;
		}
	}

	cout << lowH;

	return 0;
}