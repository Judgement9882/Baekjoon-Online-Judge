/*
	https://www.acmicpc.net/problem/25305

	커트라인
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> score;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, k; cin >> N >> k;
	while (N--) {
		int num; cin >> num;
		score.push_back(num);

	}

	sort(score.begin(), score.end(), greater<>());

	cout << score[k-1];

	return 0;
}



