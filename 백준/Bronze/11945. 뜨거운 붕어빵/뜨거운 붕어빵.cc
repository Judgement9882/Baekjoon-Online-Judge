/*
	https://www.acmicpc.net/problem/11945

	뜨거운 붕어빵
*/

#include <iostream>
using namespace std;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	
	int N, M; cin >> N >> M;
	while (N--) {
		string temp; cin >> temp;
		for (int i = M - 1; i >= 0; i--) {
			cout << temp[i];
		}
		cout << "\n";
	}
	
	
	return 0;
}