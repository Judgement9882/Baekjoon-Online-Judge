/*
	https://www.acmicpc.net/problem/1350

	진짜공간
*/

#include <iostream>

using namespace std;

long long file_num[52];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	
	for (int i = 0; i < N; i++) cin >> file_num[i];
	
	long long cluster_size;
	cin >> cluster_size;

	long long total_size = 0;
	for (int i = 0; i < N; i++) {
		if (file_num[i] == 0) continue;
		if (cluster_size >= file_num[i]) {
			total_size += cluster_size;
		}

		else {
			int temp;
			if (file_num[i] % cluster_size == 0) {
				temp = file_num[i] / cluster_size;
			}
			else {
				temp = file_num[i] / cluster_size + 1;
			}
			
			total_size += temp * cluster_size;
		}
	}
	cout << total_size;

	return 0;
}



