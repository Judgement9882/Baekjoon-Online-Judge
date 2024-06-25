#include <iostream>
using namespace std;
int arr[1000];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int A, B, C, D; cin >> A >> B >> C >> D;
    int P, M, N; cin >> P >> M >> N;
    int index = 1;
    while (index < 1000) {
        for (int i = index; i < index + A; i++) {
            arr[i] += 1;
        }
        index += (A + B);
    }
    index = 1;
    while (index < 1000) {
        for (int i = index; i < index + C; i++) {
            arr[i] += 1;
        }
        index += (C + D);
    }
    cout << arr[P] << "\n" << arr[M] << "\n" << arr[N];
    return 0;
}