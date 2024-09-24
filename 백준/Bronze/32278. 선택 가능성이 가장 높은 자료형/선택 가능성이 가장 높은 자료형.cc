#include <bits/stdc++.h>
using namespace std;
int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	long long N; cin >> N;
	if (-32768 <= N && N <= 32767) cout << "short";
	else if (-2147483648 <= N && N <= 2147483647) cout << "int";
	else cout << "long long";
	return 0;
}