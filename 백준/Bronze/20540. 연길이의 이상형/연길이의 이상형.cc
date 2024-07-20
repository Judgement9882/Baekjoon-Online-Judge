#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string mbti; cin >> mbti;
	if (mbti[0] == 'E') cout << 'I';
	else cout << "E";
	if (mbti[1] == 'N') cout << 'S';
	else cout << "N";
	if (mbti[2] == 'F') cout << 'T';
	else cout << "F";
	if (mbti[3] == 'P') cout << 'J';
	else cout << "P";
	return 0;
}