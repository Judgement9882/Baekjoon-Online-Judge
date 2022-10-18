/*
	https://www.acmicpc.net/problem/1759

	암호 만들기
*/

#include <iostream>
#include <algorithm>
using namespace std;

int L, C;
char pw[17];
int pw_index[17];

bool check_char(char T) {
	return T == 'a' || T == 'e' || T == 'i' || T == 'o' || T == 'u';
}

void func(int k, int start_index) {

	if (k == L) {

		bool flag = false;
		// 모음과 자음 개수
		int cnt_aeiou = 0, cnt_else = 0;
		
		for (int i = 0; i < L; i++) {
			if (check_char(pw[pw_index[i]])) cnt_aeiou++;
			else cnt_else++;
		}

		// 조건 만족하면 출력 시작
		if (cnt_aeiou >= 1 && cnt_else >= 2) flag = true;

		if (flag) {
			for (int i = 0; i < L; i++) {
				cout << pw[pw_index[i]];
			}
			cout << "\n";
		}

	}

	for (int i = start_index; i < C; i++) {
		pw_index[k] = i;
		func(k + 1, i + 1);
	}
}


int main()
{
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	cin >> L >> C;
	for (int i = 0; i < C; i++) {
		cin >> pw[i];
	}
	sort(pw, pw + C);

	func(0, 0);


	return 0;
}
