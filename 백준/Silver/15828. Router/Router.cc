#include <iostream>
#include <queue>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	queue<int> buf;
	while (true) {
		int num; cin >> num;
		if (num == -1) break;
		if (num == 0 && !buf.empty()) buf.pop();
		if (num != 0 && buf.size() < N) buf.push(num);
	}
	if (buf.empty()) cout << "empty";
	else {
		while (!buf.empty()) {
			cout << buf.front() << " ";
			buf.pop();
		}
	}
	return 0;
}