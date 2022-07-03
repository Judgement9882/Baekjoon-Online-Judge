/*
	https://www.acmicpc.net/problem/10822

	더하기
*/

#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack<char> st;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	string S;
	cin >> S;

	int cnt = 0;
	for (int i = 0; i <= S.length(); i++) {
		if ((i == S.length()) || (!st.empty() && S[i] == ',')) {
			// 스택이 빌 때 까지 
			int mul = 1; // 자릿수만큼 곱하는 수
			while (!st.empty()) {
				cnt += mul * (st.top() - '0'); // 아스키문자 이므로 '0'을 뺌.
				st.pop();
				mul *= 10; // 자릿수 증가
			}
		}

		else {
			st.push(S[i]);
		}
	}
	
	cout << cnt;
	return 0;
}