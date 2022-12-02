#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main(int argc, char** argv)
{

	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N, F; cin >> N >> F;
	N /= 100;
	N *= 100;
	int cnt = 0;
	for (int i = N; cnt < 100; i++, cnt++) {
		if (i % F == 0) {
			
			cout << (i % 100)/10 << i % 10;
			break;
		}
	}


	return 0;
}