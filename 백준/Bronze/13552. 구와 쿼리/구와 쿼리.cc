#include <bits/stdc++.h>
using namespace std;
using ll = long long;
struct Point {
	ll x;
	ll y;
	ll z;
	Point(ll _x, ll _y, ll _z){
		this->x = _x;
		this->y = _y;
		this->z = _z;
	}
};

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	int N; cin >> N;
	vector<Point> arr;
	for (int i = 0; i < N; ++i) {
		ll x; 
		ll y; 
		ll z;
		cin >> x >> y >> z;
		arr.push_back(Point(x, y, z));
	}

	int M; cin >> M;
	for (int i = 0; i < M; ++i) {
		ll x;
		ll y;
		ll z;
		ll r;
		cin >> x >> y >> z >> r;
		int ans = 0;
		for (int j = 0; j < N; ++j) {
			ll left = (x - arr[j].x) * (x - arr[j].x) + (y - arr[j].y) * (y - arr[j].y) + (z - arr[j].z) * (z - arr[j].z);
			ll right = r * r;
			if (left <= right) ans++;
		}
		cout << ans << "\n";
	}

	return 0;
}