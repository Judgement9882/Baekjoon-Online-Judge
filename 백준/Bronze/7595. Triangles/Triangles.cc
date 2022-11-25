#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);
	while (1) {

		int N;
		cin >> N;

		if (N == 0) break;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				cout << "*";
			}
			cout << "\n";
		}
		
	}

	

	return 0;
}