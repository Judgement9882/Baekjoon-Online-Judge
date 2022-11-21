#include <iostream>
#include <algorithm>
using namespace std;

int dp[20][20];

int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);

	string a, b; cin >> a >> b;
	
	int index = 1;
	for (int i = 0; i < 8; i++) {
		dp[1][index++] = a[i] - '0';
		dp[1][index++] = b[i] - '0';
	}

	for (int i = 2; i <= 15; i++) {
		for (int j = 1; j <= 17 - i; j++) {
			dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
		}
	}

	cout << dp[15][1] << dp[15][2];

	return 0;
}