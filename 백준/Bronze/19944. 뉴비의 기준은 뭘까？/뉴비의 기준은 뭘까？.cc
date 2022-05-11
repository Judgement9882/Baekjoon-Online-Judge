/*
	https://www.acmicpc.net/problem/19944

	뉴비의 기준

*/

#include <iostream>

using namespace std;


int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	cin >> N >> M;

	if (M == 1 || M == 2) cout << "NEWBIE!";
	else if (N >= M) cout << "OLDBIE!";
	else cout << "TLE!";
	
	return 0;
}