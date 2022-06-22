/*
	https://www.acmicpc.net/problem/17298
	
	오큰수
	3 5 2 4 7
	5 7 4 7 -1

	9 5 4 8 6
	-1 8 8 -1 -1
*/

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> A, NGE;
stack<pair<int, int>> temp;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N, num;
	cin >> N;
	while (N--) {
		cin >> num;
		A.push_back(num);
		NGE.push_back(-1);
	}

	for (int i = 0; i<A.size()-1; i++){
		// A[i] 가 A[i+1] 보다 클 경우 => stack에넣음
		if (A[i] >= A[i + 1]) {
			temp.push({ A[i], i });

		}
		// 클 경우 NGE[i] 를 A[i+1]로 갱신
		else {
			NGE[i] = A[i + 1];
			while(!temp.empty()) {
				// 비교해서 temp.top().first 가 A[i+1] 보다 작다면 꺼내기
				if (temp.top().first < A[i + 1]) {
					NGE[temp.top().second] = A[i + 1];
					temp.pop();
				}
				// 아닐경우 다음 과정으로 넘어감
				else break;
			}
		}
	}
	
	for (int i = 0; i < NGE.size(); i++) cout << NGE[i] << " ";
	
	return 0;
}
