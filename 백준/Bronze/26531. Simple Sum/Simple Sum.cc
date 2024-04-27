#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	string line; getline(cin, line);
	int A, B, C;
	A = line[0] - '0';
	B = line[4] - '0';
	C = line[8] - '0';


	if (A + B == C) cout << "YES";
	else cout << "NO";
	
	

	return 0;
}