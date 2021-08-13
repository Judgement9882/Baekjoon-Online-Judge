// https://www.acmicpc.net/problem/18870

/*
	��ǥ ����
	
	�Է¹��� �迭 ����
	�Ȱ��� �迭�� �����ϰ�
	�ٸ� �迭�� �ߺ��� ������ ����
	
*/

//#include <bits/stdc++.h>
//
//using namespace std;
//
//int A[1000002] , B[1000002], C[1000002];
//int N;
//int j = 1;
//
//int binarysearch(int val) {
//	int st = 0, ed = j; 
//
//	while (st <= ed) {
//		int mid = (st + ed) / 2;
//		if (C[mid] > val) ed = mid - 1;
//		else if (C[mid] < val) st = mid + 1;
//		else return mid;
//	}
//	return 0;
//}
//
//int main() {
//
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	cin >> N;
//	for (int i = 0; i < N; i++) {
//		cin >> A[i];
//		B[i] = A[i];
//	}
//
//	sort(B, B + N);
//	C[0] = B[0];
//	for (int i = 1; i < N; i++) {
//		if (B[i] == C[j-1]) {
//			continue;
//		}
//		C[j++] = B[i];
//	}
//
//	for (int i = 0; i < N; i++) {
//		cout << binarysearch(A[i]) << " ";
//	}
//
//	return 0;
//}

/*
	������ �ڵ�

*/

#include <bits/stdc++.h>
using namespace std;

int N;
int A[1000002];
vector<int> uniq;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
		uniq.push_back(A[i]);
	}

	sort(uniq.begin(), uniq.end());
	uniq.erase(unique(uniq.begin(), uniq.end()), uniq.end());
	for (int i = 0; i < N; i++) {
		cout << lower_bound(uniq.begin(), uniq.end(), A[i]) - uniq.begin() << " ";
	}
	return 0;
}