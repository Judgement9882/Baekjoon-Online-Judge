#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int board[1002];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, K; cin >> N >> K;
	
	int num = 0;
	for (int i = 2; i <= N; i++) {		
		for (int j = i; j <= N; j += i) {
			// 지우지 않았다면
			if (board[j] == 0) {
				board[j] = j;
				num++;
				
				if (num == K) {
					cout << j;
					return 0;
				}
			}

			// 이미 지웠대면 패스
			else {
				continue;
			}
		}
	}


	return 0;
}