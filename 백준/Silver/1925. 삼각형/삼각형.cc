#include <iostream>
#include <cmath>
#include <algorithm>

#define X first
#define Y second
#define PI 3.141592

using namespace std;

// 세 점이 일직선 상에 있는지 확인하는 함수
bool areCollinear(pair<int, int> A, pair<int, int> B, pair<int, int> C) {
	int crossProduct = (B.X - A.X) * (C.Y - A.Y) - (B.Y - A.Y) * (C.X - A.X);
	return crossProduct == 0;
}

// 길이 반환 함수 
// 최대 20000 * 20000 * 2 = 8 * 10^8 이므로 int 범위내에 있음.
int lenbetween(pair<int, int> a, pair<int, int> b) {
	return (a.X - b.X) * (a.X - b.X) + (a.Y - b.Y) * (a.Y - b.Y);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	pair<int, int> A, B, C;
	cin >> A.X >> A.Y;
	cin >> B.X >> B.Y;
	cin >> C.X >> C.Y;

	if (areCollinear(A, B, C)) cout << "X";
	else {
		int lenAB = lenbetween(A, B);
		int lenBC = lenbetween(B, C);
		int lenCA = lenbetween(C, A);
		if (lenAB == lenBC && lenAB == lenCA) cout << "JungTriangle";
		else if (lenAB == lenBC || lenBC == lenCA || lenCA == lenAB) {
			if(lenAB+lenBC == lenCA || lenBC + lenCA == lenAB || lenCA + lenAB == lenBC) cout << "Jikkak2Triangle";
			else if (lenAB+lenBC < lenCA || lenBC + lenCA < lenAB || lenCA + lenAB < lenBC) cout << "Dunkak2Triangle";
			else  cout << "Yeahkak2Triangle";
		}
		else {
			if (lenAB + lenBC == lenCA || lenBC + lenCA == lenAB || lenCA + lenAB == lenBC) cout << "JikkakTriangle";
			else if (lenAB + lenBC < lenCA || lenBC + lenCA < lenAB || lenCA + lenAB < lenBC) cout << "DunkakTriangle";
			else  cout << "YeahkakTriangle";
		}
	}
	return 0;
}