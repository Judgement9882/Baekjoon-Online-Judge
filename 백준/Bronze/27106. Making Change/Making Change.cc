#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;
int num[4];
int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	N = 100 - N;
	while (N) {
		//cout << "N : " << N << "\n";
		if (N >= 25) {
			num[3]++; N -= 25;
			continue;
		}
		if (N >= 10) {
			num[2]++; N -= 10;
			continue;
		}
		if (N >= 5) {
			num[1]++; N -= 5;
			continue;
		}
		if (N >= 1) {
			num[0]++; N--;
			continue;
		}
		
	}
	for (int i = 0; i < 4; i++) {
		cout << num[3-i] << " ";
	}
	return 0;
}

 
