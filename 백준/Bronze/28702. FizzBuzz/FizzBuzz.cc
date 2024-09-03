#include <iostream>
#include <string>
using namespace std;

string input[3];
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int num = 0;
	int idx = 0;
	for (int i = 0; i < 3; i++) {
		cin >> input[i];
		if (input[i][0] >= '0' && input[i][0] <= '9') {
			num = stoi(input[i]);
			idx = i;
		}
	}
	
	int next = num + (3 - idx);
	if (next % 15 == 0) cout << "FizzBuzz";
	else if (next % 3 == 0) cout << "Fizz";
	else if (next % 5 == 0) cout << "Buzz";
	else cout << next;
	return 0;
}