/*
	https://www.acmicpc.net/problem/14173

	Square Pasture
*/

#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int x_1, x_2, x_3, x_4;
	int y_1, y_2, y_3, y_4;

	cin >> x_1 >> y_1 >> x_2 >> y_2 >> x_3 >> y_3 >> x_4 >> y_4;

	int min_x, min_y, max_x, max_y;
	min_x = min(x_1, x_3);
	min_y = min(y_1, y_3);
	max_x = max(x_2, x_4);
	max_y = max(y_2, y_4);

	int length = max(max_x - min_x, max_y - min_y);
	cout << length * length;

	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
