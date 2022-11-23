#include <iostream>
#include <algorithm>
using namespace std;



int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);

	int N; cin >> N;
	int max_num = -999;
	int min_num = 0xFFFF;
	while (N--) {
		int temp; cin >> temp;
		max_num = max(max_num, temp);
		min_num = min(min_num, temp);
	}

	cout << max_num - min_num;

	return 0;
}