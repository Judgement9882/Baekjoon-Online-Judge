#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int T;
	cin >> T;
	
	while (T--) {
		int G, C, E;
		cin >> G >> C >> E;
		if (E <= C) cout << 0 << "\n";
		else if (G == 1) cout << E - C << "\n";
		else if (G == 2) cout << (E - C) * 3 << "\n";
		else cout << (E - C) * 5 << "\n";
	}

	return 0;
}