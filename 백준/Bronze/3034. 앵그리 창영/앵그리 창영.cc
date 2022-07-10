/*
	https://www.acmicpc.net/problem/3034

	앵그리창영
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N, W, H;
	cin >> N >> W >> H;
	
	int power_of_num = W * W + H * H;

	while (N--) {
		int num;
		cin >> num;
		if (power_of_num >= num * num) cout << "DA\n";
		else cout << "NE\n";
	}
	


	return 0;
}



