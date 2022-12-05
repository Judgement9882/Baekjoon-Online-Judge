#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int num[12];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N = 2;
	while (N--) {
		for (int i = 0; i < 10; i++) {
			cin >> num[i];
		}
		sort(num, num + 10);
		cout << num[7] + num[8] + num[9] << " ";
	}
	return 0;
}