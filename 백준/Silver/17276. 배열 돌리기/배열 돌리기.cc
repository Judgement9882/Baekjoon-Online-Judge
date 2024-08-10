#include <iostream>

using namespace std;

int n;
int A[502][502];
int temp[502];

void printA() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << A[i][j] << " ";
		}
		cout << "\n";
	}
}

void cw() {
	for (int i = 0; i < n; i++) temp[i] = A[i][i];
	for (int i = 0; i < n; i++) A[i][i] = A[n / 2][i];
	for (int i = 0; i < n; i++) A[n / 2][i] = A[n - 1 - i][i];
	for (int i = 0; i < n; i++) A[n - 1 - i][i] = A[n - 1 - i][n / 2];
	for (int i = 0; i < n; i++) A[n - 1 - i][n / 2] = temp[n - 1 - i];
}

void ccw() {
	for (int i = 0; i < n; i++) temp[i] = A[i][i];
	for (int i = 0; i < n; i++) A[i][i] = A[i][n / 2];
	for (int i = 0; i < n; i++) A[i][n / 2] = A[i][n - 1 - i];
	for (int i = 0; i < n; i++) A[i][n - 1 - i] = A[n / 2][n - 1 - i];
	for (int i = 0; i < n; i++) A[n / 2][n - 1 - i] = temp[n - 1 - i];
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int T; cin >> T;

	while (T--) {
		int d;
		cin >> n >> d;

		// input
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> A[i][j];
			}
		}

		// no change
		if (d == 0 || d == 360 || d == -360) {
			printA();
			continue;
		}

		int turn = d / 45;
		while (turn != 0) {
			if (turn > 0) {
				turn--;
				cw();
			}
			else {
				turn++;
				ccw();
			}
		}

		printA();
	}

	return 0;
}