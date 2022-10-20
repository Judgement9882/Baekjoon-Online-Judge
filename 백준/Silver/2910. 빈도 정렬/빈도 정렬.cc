/*
	https://www.acmicpc.net/problem/2910

	빈도 정렬
*/

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, C;

bool comp(pair<int, int> vt1, pair<int, int>vt2) {
	return vt2.first < vt1.first;
}

int main()
{
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	cin >> N >> C;

	vector<pair<int, int>> vt; // (cnt, num)
	for (int i = 0; i < N; i++) {
		int num; cin >> num;
		bool flag = false;
		for (auto &k : vt) {
			if (k.second == num) {
				k.first++;
				flag = true;
				break;
			}
		}
		if (!flag) vt.push_back({ 1, num });
	}

	stable_sort(vt.begin(), vt.end(), comp);

	for (auto &k : vt) {
		while (k.first > 0) {
			cout << k.second << " ";
			k.first--;
		}
	}

	return 0;
}
