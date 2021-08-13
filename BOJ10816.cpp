// https://www.acmicpc.net/submit/10816

/*
	binary search

	값이 같은 카드가 여러장이 있다면
	그 값이 나오기 전의 index, 후의 index+1 의 차이를 구한다.

*/

#include <bits/stdc++.h>
using namespace std;

int A[500002];
int t;

int bs(int val) {
	int st = 0;
	int ed = t;
	int before_val = 0;
	int after_val = 0;

	while (st <= ed) {
		int mid = (st + ed) / 2;
		if (A[mid] < val) {
			st = mid + 1;
		}
		else if (A[mid] > val) {
			ed = mid - 1;
		}
		else {
			if (mid == 0) {
				before_val = 0;
				break;
			}
			else if (A[mid - 1] != val) {
				before_val = mid;
				break;
			}
			else {
				ed = mid - 1;
			}
		}
	}

	st = 0; ed = t;

	while (st <= ed) {
		int mid = (st + ed) / 2;
		if (A[mid] < val) {
			st = mid + 1;
		}
		else if (A[mid] > val) {
			ed = mid - 1;
		}
		else {
			if (mid == t) {
				after_val = t+1;
				break;
			}
			else if (A[mid + 1] != val) {
				after_val = mid+1;
				break;
			}
			else {
				st = mid + 1;
			}
		}
	}

	return after_val - before_val;
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> A[i];
	}
	
	sort(A, A + t);
	
	int T;
	cin >> T;
	while (T--) {
		int temp;
		cin >> temp;
		cout << bs(temp) << " ";
	}

	return 0;
}