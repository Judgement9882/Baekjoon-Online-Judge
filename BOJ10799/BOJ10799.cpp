// https://www.acmicpc.net/problem/10799

/*
	경우의 수
	
	- () 혼자있는 경우.
	- ( () ) 쇠막대기 안에 있는 경우
	- ( ( () ) ) n개 안에 있는경우
	- ( () ( () )) 하나는 하나만, 다른하나는 동시에

	)가 나왔을 때 +스택 사이즈 
	)앞에 )가 있을 때 +1
*/

#include <bits/stdc++.h>

using namespace std;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(0);

	string temp;
	cin >> temp;
	
	stack<char> st;
	int cnt = 0;

	for (int i = 0; i < temp.length(); i++) {
		if (temp[i] == '(') st.push(temp[i]);
		else if (temp[i] == ')'){
			st.pop();

			// stack empty -> pass
			if (st.empty()) {
				if (i > 0 && temp[i - 1] == ')') cnt++;
				// cout << st.size() << " " << cnt << "\n";
				continue;
			}
			else {
				// next is the end of iron_stick
				if (i > 0 && temp[i - 1] == ')') cnt++;

				else cnt += st.size(); // stack.size() -> the number of stick
			}
		}
		// cout << st.size() << " " << cnt << "\n";
	}

	cout << cnt;

	return 0;
}