#include <iostream>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	string temp;
	cin >> temp;
	int idx = 0;
	while (1) if (temp[idx++] == 'h') break;
	int idx_h = 0;
	cin >> temp;
	while (1) if (temp[idx_h++] == 'h') break;
	if (idx >= idx_h) cout << "go";
	else cout << "no";
	return 0;
}