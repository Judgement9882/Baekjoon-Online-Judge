/*
	https://www.acmicpc.net/problem/3015

	오아시스 재결합
*/

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> tall;
stack<pair<int, int>> st;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, height;
	long long cnt = 0;
	cin >> N;
	while (N--) {
		cin >> height;
		tall.push_back(height);
	}

	for (int i = 0; i < tall.size(); ) {

		// tall[i] 가 더 클 경우 다 빼야함
		while (!st.empty() && st.top().first < tall[i]) {
			cnt += st.top().second;
			st.pop();
		}

		// 비어있으면 추가
		if (st.empty()) {
			st.push({ tall[i], 1 });
			i++;
		}

		else {
			// stack안에 있는 내용물이 tall[i] 보다 크면
			if (st.top().first > tall[i]) {
				cnt++;
				st.push({ tall[i], 1 });
				i++;
			}

			// 같다면
			else if (st.top().first == tall[i]) {
				pair<int, int> cur = st.top();
				st.pop();

				cnt += cur.second;
				//스택 내 제일 큰 사람과 쌍을 이룸
				if (!st.empty())
					cnt++;

				//연속해서 같은 키가 나오므로
				cur.second++;
				st.push(cur);
				i++;
			}

		}

		//if (!st.empty()) {
		//	cout << "cnt : " << cnt << " st top, second :  " << st.top().first << " " << st.top().second << "\n";
		//}
	}

	cout << cnt;

	return 0;
}