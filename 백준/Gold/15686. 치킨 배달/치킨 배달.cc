/*
	https://www.acmicpc.net/problem/15686

	치킨배달
*/

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int board[52][52];

vector<pair<int, int>> chicken;
vector<pair<int, int>> house;
int N, M;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
			// 치킨집인 경우 좌표 저장
			if (board[i][j] == 2) {
				chicken.push_back({ i, j });
			}
			// 집인경우 좌표 저장
			else if (board[i][j] == 1) { 
				house.push_back({ i, j });
			}
		}
	}
	
	// 치킨집의개수_C_M 을 만들기 위한 brute 벡터
	vector<int> brute(chicken.size(), 1);

	// M개의 치킨집만 남겨야 하므로 전체개수에서 M개를 뺀만큼 0으로 채우면 M개의 1만 남음.
	fill(brute.begin(), brute.begin() + chicken.size() - M, 0);

	int dist = 0x7fffffff; // 치킨거리
	do {
		int temp_dist = 0; // 모든 경우의 수에 임시로 쓰는 치킨거리
		for (auto k : house) { // 집을 하나씩 꺼내서
			int temp = 0x7fffffff; // 집과 각 치킨점의 거리를 계산할 거리변수
			for (int i = 0; i < chicken.size(); i++) {
				if (brute[i] == 0) continue; // 치킨집이 제외되는 경우 넘김
				temp = min(temp, abs(chicken[i].first - k.first) + abs(chicken[i].second - k.second));
			}
			temp_dist += temp;
		}
		dist = min(dist, temp_dist);
		
	} while (next_permutation(brute.begin(), brute.end())); 
	cout << dist;
	return 0;
}



