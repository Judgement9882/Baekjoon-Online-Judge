/*
	https://www.acmicpc.net/problem/2864
	
	헷갈리는 5, 6
*/

#include <iostream>
#include <string>
using namespace std;


int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	string A, B, A_min, A_max, B_min, B_max;
	cin >> A >> B;
	A_min = A;
	A_max = A;
	B_min = B;
	B_max = B;

	for (int i = 0; i < A.length(); i++) {
		if (A[i] == '5') A_max[i] = '6';
		else if (A[i] == '6') A_min[i] = '5';
	}

	for (int i = 0; i < B.length(); i++) {
		if (B[i] == '5') B_max[i] = '6';
		else if (B[i] == '6') B_min[i] = '5';
	}

	cout << stoi(A_min) + stoi(B_min) << " " << stoi(A_max) + stoi(B_max);

}
