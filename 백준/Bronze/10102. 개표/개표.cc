#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N; cin >> N;
	string temp; cin >> temp;

	int num_a = 0, num_b = 0;
	for (int i = 0; i < N; i++) {
		if (temp[i] == 'A') num_a++;
		else num_b++;
	}
	if (num_a == num_b) {
		cout << "Tie";
	}
	else if (num_a > num_b) {
		cout << "A";
	}
	else {
		cout << "B";
	}

	return 0;
}