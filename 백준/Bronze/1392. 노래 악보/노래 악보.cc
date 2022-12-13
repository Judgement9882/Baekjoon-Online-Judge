#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int N_time[100002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N, Q; cin >> N >> Q;
	int index = 0;
	for (int i = 1; i <= N; i++) {
		int temp; cin >> temp;
		while (temp > 0) {
			N_time[index++] = i;
			temp--;
		}
	}

	for (int i = 0; i < Q; i++) {
		int temp; cin >> temp;
		
		cout << N_time[temp] << "\n";
	}
	


	return 0;
}