/*
	https://www.acmicpc.net/problem/2399

	거리합
*/

#include <iostream>
#include <cmath>
using namespace std;

long long dot[10002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N;  cin >> N;
	long long cnt = 0;
	for (int i = 1; i <= N; i++) {
		cin >> dot[i];
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (i == j) continue;
			cnt += abs(dot[i] - dot[j]);
		}
	}
	cout << cnt;

	return 0;
}