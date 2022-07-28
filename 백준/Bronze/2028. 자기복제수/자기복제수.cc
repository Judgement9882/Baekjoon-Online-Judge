/*
	https://www.acmicpc.net/problem/2028

	자기복제수
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	
	int N;
	cin >> N;

	int power_num = 0;
	while (N--) {
		int num;
		cin >> num;
		
		power_num = num * num;
		int div = 1;
		for (int i = 0; i < to_string(num).length(); i++) {
			div *= 10;
		}
		if (power_num % div == num) cout << "YES\n";
		else cout << "NO\n";
		
	}

	return 0;
}



