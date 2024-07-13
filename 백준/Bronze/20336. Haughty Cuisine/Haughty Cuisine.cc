#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	int d; cin >> d; cout << d << "\n";
	while (d--) {
		string temp; cin >> temp;
		cout << temp << "\n";
	}

	N--;
	while (N--) {
		cin >> d;
		while (d--) {
			string temp; cin >> temp;
		}
	}
	
	return 0;
}