#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int arr[3];
	for (int i = 0; i < 3; i++) cin >> arr[i];
	sort(arr, arr+3);
	
	if (arr[2] - arr[1] == arr[1] - arr[0]) cout << arr[2] + (arr[2] - arr[1]);
	else if (arr[2] - arr[1] > arr[1] - arr[0]) {
		cout << arr[2] - (arr[1] - arr[0]);
	}
	else {
		cout << arr[1] - (arr[2] - arr[1]);
	}
	return 0;
}