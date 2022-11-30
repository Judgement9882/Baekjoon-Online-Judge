#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool board[20000004];


int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int plus = 10000000;

	int N, M; cin >> N;
	while (N--) {
		int temp; cin >> temp;  
		board[temp + plus] = true;
	}
	cin >> M;
	while (M--) {
		int temp; cin >> temp;
		if (board[temp + plus]) cout << "1" << " ";
		else cout << "0" << " ";

	}

	return 0;
}