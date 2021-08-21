// https://www.acmicpc.net/problem/6763

#include <bits/stdc++.h>

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int S, K;
	cin >> S >> K;
	
	if (S - K >= 0) cout << "Congratulations, you are within the speed limit!";
	else if (S - K >= -20) cout << "You are speeding and your fine is $100.";
	else if (S - K >= -30) cout << "You are speeding and your fine is $270.";
	else  cout << "You are speeding and your fine is $500.";


	return 0;
}