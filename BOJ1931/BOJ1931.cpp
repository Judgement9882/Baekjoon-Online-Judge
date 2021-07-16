/*
	BOJ 1931
	Point : Sort by end time of the conference 
	-> can host many conference
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	// I/O speed management
	cin.tie(0); 
	ios_base::sync_with_stdio(false);
	
	int N;
	cin >> N; // the number of conference

	vector<pair<int, int>> con;
	
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		auto c = make_pair(b, a);
		con.push_back(c);
	}

	sort(con.begin(), con.end());

	int maxCount = 1; // answer
	int compareNum = con[0].first;
	
	// count num
	for (int i= 1; i < con.size(); i++) {
		
		if (compareNum > con[i].second) {
			continue;
		}
		compareNum = con[i].first;
		maxCount++;
	}

	cout << maxCount;

	return 0;
}