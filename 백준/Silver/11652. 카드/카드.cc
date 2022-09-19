/*
	https://www.acmicpc.net/problem/11652

	카드
*/

#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
using ll = long long;
ll card[100005];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	int N; cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> card[i];
	}

	sort(card, card + N);
	
	ll cmpCard = card[0];
	int cnt = 1;
	int maxcnt = -999;
	ll ans = 0;
	for (int i = 1; i < N; i++) {
		if (card[i] == cmpCard) cnt++;
		else {
			if (maxcnt < cnt) {
				ans = cmpCard;
				maxcnt = cnt;
			}
			cmpCard = card[i];
			cnt = 1;
		}
	}
	if (maxcnt < cnt) ans = cmpCard;
	cout << ans;
	
	return 0;
}