#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	// I/O speed management
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	int N;
	cin >> N;

	vector<int> num;
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		num.push_back(a);
	}

	int M;
	cin >> M;
	vector<int> mum;
	for (int i = 0; i < M; i++) {
		int a;
		cin >> a;
		mum.push_back(a);
	}
	
	sort(num.begin(), num.end());
	
	for (int i = 0; i < M; i++) {
		cout << binary_search(num.begin(), num.end(), mum[i]) << "\n";
	}

	return 0;
}