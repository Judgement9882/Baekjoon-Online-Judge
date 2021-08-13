// https://www.acmicpc.net/problem/2295

/*
	���ճ��� ������ 3���� ������ ���� �ٸ� �ϳ��� �� ��
	�� �� �ִ� ���� ū ���Ҹ� ���ϴ� ����.

	�̺�Ž������ st, mid, ed �� ���� ���ؼ�
	������ st�� mid��, ũ�� ed�� mid�� �ٲ㰡�鼭
	�񱳸� �غ��� ������ return
	������ 0�� return�ϰ� �ٽ� ����.

	�Ѱ� : O(N^3lgN)�̶� �ð��ʰ���.
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
//	// �ּ� 3���� ���� ���ϱ� ������ i>=3
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
	������ �ڵ�.
	�ΰ��� ���� ���� ���ؼ� ������ ��
	�ΰ��� ���� ���ؼ� ������ return
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