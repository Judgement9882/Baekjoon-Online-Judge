/*
	https://www.acmicpc.net/problem/1547
	
	컵 바꾸기
*/

#include <iostream>

using namespace std;

int main() {

	
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int pos[4] = {0, 1, 2, 3 };

	int M, X, Y;
	cin >> M;
	while (M--) {
		cin >> X >> Y;
		swap(pos[X], pos[Y]);
	}

	for (int i = 1; i <= 3; i++) {
		if (pos[i] == 1) cout << i;
	}


	return 0;
}
