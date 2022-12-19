#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int num[500002];
unsigned int N;
int num_index[8002];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N;

	long long sum = 0;
	int max_val = -999999;
	int min_val = 9999999;

	for (int i = 0; i < N; i++) {
		cin >> num[i];
		sum += num[i];
		num_index[num[i] + 4000]++;
		max_val = max(max_val, num[i]);
		min_val = min(min_val, num[i]);
	}

	// 1
	bool flag = false;
	if (sum < 0) {
		flag = true;
		sum *= -1;
	}
	sum *= 10;
	sum /= N;
	if (sum % 10 >= 5) {
		sum += 10;
		sum /= 10;
	}
	else {
		sum /= 10;
	}
	if (flag) sum *= -1;

	cout << sum << "\n";

	// 2 
	sort(num, num + N);
	cout << num[N / 2] << '\n';
	
	// 3
	int max_cnt = *max_element(num_index, num_index + 8002);
	
	int same_cnt = 0;
	vector<int> temp;
	for (int i = 0; i < 8002; i++) {
		if (max_cnt == num_index[i]) {
			same_cnt++;
			temp.push_back(i);
		}
	}
	if (same_cnt >= 2) {
		sort(temp.begin(), temp.end());
		cout << temp[1]-4000 << "\n";
	}
	else if (same_cnt == 1){
		cout << temp[0]-4000 << "\n";
	}
	

	// 4
	//cout << max_val;
	//cout << min_val;
	cout << max_val - min_val;

	return 0;
}