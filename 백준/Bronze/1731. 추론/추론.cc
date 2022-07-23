/*
	https://www.acmicpc.net/problem/1731

	추론
*/

#include <iostream>
using namespace std;
int num[52];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) cin >> num[i];
	
	int cha = 1; // 등차수열 flag
	int chaValue = num[1] - num[0];
	int bee = 1; // 등비수열 flag
	int beeValue=0;
	if (num[1] % num[0] != 0) bee = 0;
	else beeValue = num[1] / num[0];

	for (int i = 2; i < N; i++) {

		if (num[i] - num[i - 1] != chaValue) cha = 0;
		if (num[i] % num[i-1] != 0 || num[i] / num[i - 1] != beeValue) bee = 0;

		// 둘 중 하나라도 1이라면 break
		if ((bee ^ cha) == 1) break;
	}
	if (cha) cout << num[N - 1] + chaValue;
	if (bee) cout << num[N - 1] * beeValue;

	return 0;
}



