#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

string year[2030];

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	
	year[1995] = "ITMO";
	year[1996] = "SPbSU";
	year[1997] = "SPbSU";
	year[1998] = "ITMO";
	year[1999] = "ITMO";
	year[2000] = "SPbSU";
	year[2001] = "ITMO";
	year[2002] = "ITMO";
	year[2003] = "ITMO";
	year[2004] = "ITMO";
	year[2005] = "ITMO";
	year[2006] = "PetrSU, ITMO";
	year[2007] = "SPbSU";
	year[2008] = "SPbSU";
	year[2009] = "ITMO";
	year[2010] = "ITMO";
	year[2011] = "ITMO";
	year[2012] = "ITMO";
	year[2014] = "ITMO";
	year[2015] = "ITMO";
	year[2016] = "ITMO";
	year[2017] = "ITMO";
	year[2019] = "ITMO";
	year[2013] = "SPbSU";
	year[2018] = "SPbSU";
	cout << year[N];
	return 0;
}