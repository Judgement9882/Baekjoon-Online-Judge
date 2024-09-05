#include <iostream>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int N; cin >> N;
	switch (N) {
	case 1:
		cout << 11 << "\n" << "A B C D E F G H J L M";
		break;
	case 2:
		cout << 9 << "\n" << "A C E F G H I L M";
		break;
	case 3:
		cout << 9 << "\n" << "A C E F G H I L M";
		break;
	case 4:
		cout << 9 << "\n" << "A B C E F G H L M";
		break;
	case 5:
		cout << 8 << "\n" << "A C E F G H L M";
		break;
	case 6:
		cout << 8 << "\n" << "A C E F G H L M";
		break;
	case 7:
		cout << 8 << "\n" << "A C E F G H L M";
		break;
	case 8:
		cout << 8 << "\n" << "A C E F G H L M";
		break;
	case 9:
		cout << 8 << "\n" << "A C E F G H L M";
		break;
	case 10:
		cout << 8 << "\n" << "A B C F G H L M";
		break;
	}
	return 0;
}