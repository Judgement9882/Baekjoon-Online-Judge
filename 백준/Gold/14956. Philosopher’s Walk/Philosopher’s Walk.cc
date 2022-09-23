/*
	https://www.acmicpc.net/problem/14956

	Philosopher's Walk
*/

#include <iostream>
#include <algorithm>

using namespace std;


pair<int, int> philo(int side, int walk){

	// side 의 길이가 2인 경우
	if (side == 2) {
		if (walk == 1) return { 1,1 };
		else if (walk == 2) return { 1, 2 };
		else if (walk == 3) return { 2, 2 };
		else if (walk == 4) return { 2, 1 };
	}
	/*if (side == 2) {
		switch (walk) {
		case 1:
			return { 1, 1 };
		case 2:
			return { 1, 2 };
		case 3:
			return { 2, 2 };
		case 4:
			return { 2, 1 };
		}
	}*/

	// 구역을 나누기 위해 side를 반으로 나눔
	int half = side / 2;
	
	// 해당 구역의 walk를 4개로 나눔 (side^2 / 4)
	int section = half * half; 

	// 영역을 나누어서 계산
	if (walk <= section) {

		// 좌하단의 경우. 해당 모형은 이전 단계의 모양을 90도 회전시킨것과 같음.
		// 따라서 side 길이를 반으로 줄인 half를 첫번째 인자로
		// walk수는 변화없으므로 그대로 넣는다.
		pair<int, int> rv = philo(half, walk);

		// 자세히보면 좌하단의 모양과 이전 모델의 모양이 y=x 대칭이다.
		// 따라서 둘의 값을 반대로 리턴하면된다.
		return { rv.second, rv.first };
	}
	
	// 좌상단
	else if (walk <= 2 * section) {

		// 좌상단의 경우, 이전 단계의 모델과 모양이 같고, 단순히 y 좌표의 크기만 커졌다.
		// 따라서 side의 길이를 반으로 줄인 half를 첫번째 인자로 넣고
		// walk 수는 해당구역 이전의 walk만큼 뺀다 (section)
		pair<int, int> rv = philo(half, walk - section);

		// rv의 값은 이전모양에서 얻은 값이므로 y값에서 half를 더해 return 해준다.
		return { rv.first, half + rv.second };
	}

	// 우상단
	else if (walk <= 3 * section) {
		// 우상단의 경우 이전단계와 모양이 같고 x, y 좌표가 커졌다.
		// side는 똑같이 half이고 walk는 이미 두 칸을 지나쳐왔기 때문에 2*section을 뺀다.
		pair<int, int> rv = philo(half, walk - 2 * section);

		// 좌표는 우상단이기때문에 half를 양쪽에 더해준다.
		return { half + rv.first, half + rv.second };
	}

	// 우하단의 경우 90도 회전
	else {
		// 우하단의 경우 side는 half, 3칸을 지나쳐왔기 때문에 -3*section을 해준다.
		pair<int, int> rv = philo(half, walk - 3 * section);

		// 시작 좌표가 우상단에서부터 시작하는데 이전 모양에서는 좌하단에서 부터 시작한다.
		// 그러므로 -x, -y 를 써야하며 
		// 다음 좌표가 -y인데 이전 모양에서는 +x이므로 x, y가 바뀌어서 들어가야한다.(y=-x 대칭)
		// 그래서 rv.second를 처음 리턴값으로 넣어야한다.

		// 추가로 x 좌표는 (1,1)을 기준으로 계산하면 큰 사각형의 길이 side 에 - y + 1 이 된다.
		// y좌표는 반토막낸 side/2 == half 에서 -x +1 만큼 이동한다.
		return { 2 * half - rv.second + 1, half - rv.first + 1 };
	}
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N, M;
	cin >> N >> M;

	pair<int, int> ans = philo(N, M);
	cout << ans.first << " " << ans.second;


	return 0;
}
