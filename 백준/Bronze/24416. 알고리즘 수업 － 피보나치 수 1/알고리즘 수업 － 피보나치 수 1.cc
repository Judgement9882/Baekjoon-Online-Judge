#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

long long cnt1 = 1;

int f[42];

long long fib(int n) {
	
	if (n == 1 || n == 2) return 1; 
	else {
		cnt1++;
		return (fib(n - 1) + fib(n - 2));
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	fib(N);
	cout << cnt1 << " " << N - 2;



	return 0;
}