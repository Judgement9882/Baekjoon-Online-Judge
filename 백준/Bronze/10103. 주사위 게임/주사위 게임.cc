/*
	https://www.acmicpc.net/problem/9325
	
	주사위게임
*/

#include <iostream>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int n, CY, SD, CY_score = 100, SD_score=100;
	cin >> n;
	while (n--) {
		cin >> CY >> SD;
		if (CY == SD) continue;
		else if (CY > SD) SD_score -= CY;
		else CY_score -= SD;
	}
	cout << CY_score << "\n" << SD_score;


	return 0;
}
