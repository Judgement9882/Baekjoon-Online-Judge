#include <iostream>
#include <vector>
using namespace std;
vector<int> A;

int binary_search(int value, int left, int right) {
    int mid = (left + right) / 2;
    if (A[mid] == value) return 0; // 바로 찾으면 바로 찾았으니 0번
    else if (value < A[mid]) return 1 + binary_search(value, left, mid - 1); // 다르다면 한번 더 찾기
    else return 1 + binary_search(value, mid + 1, right); // 다르다면 한번 더 찾기
}

int ternary_search(int value, int left, int right) {
    int left_third = left + (right - left) / 3;
    int right_third = right - (right - left) / 3;
    if (A[left_third] == value) return 0; // 바로 찾으면 0번
    else if (A[right_third] == value) return 1; // left_third를 체크한 후 찾았으니 1번
    else if (value < A[left_third]) return 2 + ternary_search(value, left, left_third - 1); // 범위 바꿔서 삼중탐색
    else if (value < A[right_third]) return 2 + ternary_search(value, left_third + 1, right_third - 1); // 범위 바꿔서 삼중탐색
    else return 2 + ternary_search(value, right_third + 1, right); // 범위 바꿔서 삼중탐색
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N; cin >> N;
    for (int i = 0; i < N; i++) A.push_back(i);
    int ans1 = 0, ans2 = 0, ans3 = 0;
    for (int i = 0; i < N; i++) {
        int B = binary_search(A[i], 0, N - 1);
        int T = ternary_search(A[i], 0, N - 1);
        if (B < T) ans1++;
        else if (B == T) ans2++;
        else ans3++;
    }
    cout << ans1 << "\n" << ans2 << "\n" << ans3;
    return 0;
}