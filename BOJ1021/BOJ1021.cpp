#include <bits/stdc++.h>

using namespace std;

int main() {

	deque<int> Q;
	int M, N;
	cin >> M >> N;
	for (int i = 1; i <= M; i++) {
		Q.push_back(i);
	}
	
	int count = 0;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		
		while (1) {

			
			if (Q.front() == num) {
				Q.pop_front();
				break;
			}

			else {
				int index = 0;
				for (auto k : Q) {
					if (k == num) {
						break;
					}
					index++;
				}

				if ((Q.size() /2 ) >= index) {
					while (Q.front() != num) {
						int temp = Q.front();
						Q.pop_front();
						Q.push_back(temp);
						count++;
						// check
						/*
						for (int j = 0; j < Q.size(); j++) {
							cout << Q[j] << " ";
						}
						cout << "\n";
						*/
					}
				}
				else {
					while (Q.front() != num) {
						int temp = Q.back();
						Q.pop_back();
						Q.push_front(temp);
						count++;
						// check
						/*
						for (int j = 0; j < Q.size(); j++) {
							cout << Q[j] << " ";
						}
						cout << "\n";
						*/
					}
				}
			}
		}
	}

	cout << count;

	return 0;
}