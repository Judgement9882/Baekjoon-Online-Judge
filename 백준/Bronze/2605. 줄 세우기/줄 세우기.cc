/*
	https://www.acmicpc.net/problem/2605

	줄 세우기
*/

#include <iostream>
#include <list>
using namespace std;

list<int> order;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, n;
	cin >> T;

	cin >> n;
	order.push_back(1);



	for (int i = 2; i <= T; i++) {
		cin >> n;

		if (n == 0) {
			order.push_front(i);
		}
		else {
			list<int>::iterator t = order.begin();
			while (n--) t++;
			order.insert(t, i);
		}
	}
	
	for (auto i = order.rbegin(); i != order.rend(); i++){
		cout << *i << " ";
	}


	return 0;
}