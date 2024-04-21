#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int N, M, K;
	cin >> N >> M >> K;
	
	int jump = 0;
	int rabbit = N, dog = 0;
	while (rabbit > dog) {
		jump++;
		rabbit += M;
		dog += K;
	}

	cout << jump;
	return 0;
}