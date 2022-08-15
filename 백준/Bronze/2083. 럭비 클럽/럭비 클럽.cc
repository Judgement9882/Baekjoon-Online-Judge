/*
	https://www.acmicpc.net/problem/2083

	럭비클럽
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	string name;
	int age;
	int weight;
	string state="Senior";

	while (1) {
		cin >> name >> age >> weight;
		if (name == "#" && age == 0 && weight == 0) break;

		if (age > 17 || weight >= 80) state = "Senior";
		else state = "Junior";

		cout << name << " " << state << "\n";
	}
	
	return 0;
}