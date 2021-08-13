// https://www.acmicpc.net/problem/2295

/*
	집합내에 원소중 3개의 원소의 합이 다른 하나가 될 때
	될 수 있는 가장 큰 원소를 구하는 문제.

	이분탐색으로 st, mid, ed 의 합을 구해서
	작으면 st를 mid로, 크면 ed를 mid로 바꿔가면서
	비교를 해보고 있으면 return
	없으면 0을 return하고 다시 시작.

	한계 : O(N^3lgN)이라 시간초과뜸.
*/

//#include <bits/stdc++.h>
//using namespace std;
//
//int N;
//int A[1002];
//
//
//int binaryplus(int val, int last) {
//	int st = 0, ed = last - 1;
//	while (st <= ed) {
//		int mid = (st + ed) / 2;
//		// if (mid == st || mid == ed) break;
//		if (val > A[st] + A[mid] + A[ed]) st = mid;
//		else if (val < A[st] + A[mid] + A[ed]) ed = mid;
//		else return val;
//	}
//	return 0;
//}
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	cin >> N;
//	for (int i = 0; i < N; i++) {
//		cin >> A[i];
//	}
//
//	sort(A, A + N);
//	
//	// 최소 3개의 합을 구하기 때문에 i>=3
//	for (int i = N-1; i >= 3; i--) {
//		int temp = binaryplus(A[i], i);
//		if (temp) {
//			cout << temp;
//			return 0;
//		}
//	}
//
//	return 0;
//}

/*
	선생님 코드.
	두개의 합을 먼저 구해서 저장한 뒤
	두개의 차를 비교해서 있으면 return
	O(N^2logN)
*/

#include <bits/stdc++.h>
using namespace std;

int n;
int a[1005];
vector<int> two;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++)
            two.push_back(a[i] + a[j]);
    }
    sort(two.begin(), two.end());
    for (int i = n - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (binary_search(two.begin(), two.end(), a[i] - a[j])) {
                cout << a[i];
                return 0;
            }
        }
    }
}