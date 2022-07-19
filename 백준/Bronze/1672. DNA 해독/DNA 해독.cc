/*
	https://www.acmicpc.net/problem/1672

	염기서열
*/

#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

stack<char> st;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	char temp;
	int N, num;
	cin >> N;
	num = N-1;
	while (N--) {
		cin >> temp;
		st.push(temp);
	}
	while (num--) {
		if (st.empty()) break;
		char temp1 = st.top();
		st.pop();
		char temp2 = st.top();
		st.pop();

		if (temp1 == temp2) st.push(temp1);
		// 다를경우
		else {
			if (temp1 < temp2) swap(temp1, temp2);
			if (temp1 == 'A') {
				if (temp2 == 'G') st.push('C');
				else if (temp2 == 'C') st.push('A');
				else if (temp2 == 'T') st.push('G');
			}
			else if (temp1 == 'G') {
				if (temp2 == 'A') st.push('C');
				else if (temp2 == 'C') st.push('T');
				else if (temp2 == 'T') st.push('A');
			}
			else if (temp1 == 'C') {
				if (temp2 == 'A') st.push('A');
				else if (temp2 == 'G') st.push('T');
				else if (temp2 == 'T') st.push('C');
			}
			else if (temp1 == 'T') {
				if (temp2 == 'A') st.push('G');
				else if (temp2 == 'G') st.push('A');
				else if (temp2 == 'C') st.push('G');
			}
		}
	}
	cout << st.top();


	return 0;
}



