/*
	https://www.acmicpc.net/problem/18130

	여름나기
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, H;
	cin >> T >> H;
	
	long long min_price = 0x7fffffffffffffff;
	int index = 0;

	for(int i = 1; i <= T; i++){

		long long P, K, C;
		cin >> P >> K >> C;

		long long temp_per_price = H / K;

		// 나누어 떨어지면 
		if (H % K == 0) temp_per_price -= 1;

		long long temp_price = P;
		temp_price = P + (temp_per_price * (temp_per_price + 1) / 2) * C;
		
		// cout << i << " " << temp_price << "\n";
		if (min_price > temp_price) {
			min_price = temp_price;
			index = i;
		}

	}

	cout << index << " " << min_price;

	return 0;
}



