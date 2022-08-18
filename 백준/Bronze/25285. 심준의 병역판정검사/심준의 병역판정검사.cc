/*
	https://www.acmicpc.net/problem/25285

	신검
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	
	int T; cin >> T;
	while (T--) {
		float height, weight; cin >> height >> weight;
		float bmi = weight / ((height/100) * (height/100));
		if (height <= 140) {
			cout << "6\n";
			continue;
		}
		else if (height > 140 && height < 146) {
			cout << "5\n";
			continue;
		}
		else if (height >= 146 && height < 159) {
			cout << "4\n";
			continue;
		}
		else if (height >= 159 && height < 161) {
			if (bmi < 16 || bmi >= 35) cout << "4\n";
			else if (bmi >= 16 && bmi < 35) cout << "3\n";
			continue;
		}
		else if (height >= 161 && height < 204) {
			if (bmi < 16 || bmi >= 35) cout << "4\n";
			else if ((bmi >= 16 && bmi < 18.5) || (bmi >= 30 && bmi < 35)) cout << "3\n";
			else if ((bmi >= 18.5 && bmi < 20) || (bmi >= 25 && bmi < 30)) cout << "2\n";
			else if (bmi >= 20 && bmi < 25) cout << "1\n";
			continue;
		}
		else cout << "4";

	}
	
	
	return 0;
}