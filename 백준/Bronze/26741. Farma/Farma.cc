#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int X, Y; cin >> X >> Y;
	int cnt_y = 0;

	if (X * 2 == Y) {
		cout << X << " 0";
	}
	else if (X * 4 == Y) {
		cout << "0 " << X;
	}
	else {
		while (!(X * 2 == Y)) {
			X--; Y -= 4; cnt_y++;
		}

		cout << X << " " << cnt_y;
	}


	

	return 0;
}