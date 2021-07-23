// https://www.acmicpc.net/problem/10799

/*
	����� ��
	
	- () ȥ���ִ� ���.
	- ( () ) �踷��� �ȿ� �ִ� ���
	- ( ( () ) ) n�� �ȿ� �ִ°��
	- ( () ( () )) �ϳ��� �ϳ���, �ٸ��ϳ��� ���ÿ�

	)�� ������ �� +���� ������ 
	)�տ� )�� ���� �� +1
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