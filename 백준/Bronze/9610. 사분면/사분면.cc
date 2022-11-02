/*
	https://www.acmicpc.net/problem/9610

	사분면
*/

#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N; cin >> N;
	int pos[5] = { 0, };
	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		if (x == 0 || y == 0) pos[4]++;
		else if (x > 0 && y > 0) pos[0]++;
		else if (x < 0 && y > 0) pos[1]++;
		else if (x < 0 && y < 0) pos[2]++;
		else if (x > 0 && y < 0) pos[3]++;
	}
	
	cout << "Q1: " << pos[0] << "\n";
	cout << "Q2: " << pos[1] << "\n";
	cout << "Q3: " << pos[2] << "\n";
	cout << "Q4: " << pos[3] << "\n";
	cout << "AXIS: " << pos[4];
	
	return 0;
}