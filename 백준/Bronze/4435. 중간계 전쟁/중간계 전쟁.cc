/*
	https://www.acmicpc.net/problem/4435

	중간계 전투
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	for(int i = 1 ; i <= T ; i++){
		
		int val = 0;
		int gan = 0; // 간달프
		int sa = 0; // 사우론

		cin >> val; gan += val * 1;
		cin >> val; gan += val * 2;
		cin >> val; gan += val * 3;
		cin >> val; gan += val * 3;
		cin >> val; gan += val * 4;
		cin >> val; gan += val * 10;

		cin >> val; sa += val * 1;
		cin >> val; sa += val * 2;
		cin >> val; sa += val * 2;
		cin >> val; sa += val * 2;
		cin >> val; sa += val * 3;
		cin >> val; sa += val * 5;
		cin >> val; sa += val * 10;
		
		cout << "Battle " << i << ": ";
		if (gan > sa) cout << "Good triumphs over Evil\n";
		else if (gan < sa) cout << "Evil eradicates all trace of Good\n";
		else cout << "No victor on this battle field\n";
	}

	return 0;
}



