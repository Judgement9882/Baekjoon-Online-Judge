#include <bits/stdc++.h>
using namespace std;

int N;

void line(int n) {
	for (int i = 0; i < n; i++) {
		cout << "____";
	}
}

void recur(int n) {
	line(N - n);
	cout << "\"����Լ��� ������?\"" << "\n";
	if (n == 0) {
		line(N - n);
		cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"" << "\n";
		for (int i = 0; i <= N; i++) {
			line(N - i);
			cout << "��� �亯�Ͽ���." << "\n";
		}
		return;
	}
	else {
		line(N - n);
		cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���." << "\n";
		line(N - n);
		cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���." << "\n"; 
		line(N - n);
		cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"" << "\n";
	}
	
	recur(n-1);
}

int main() {
	
	cin >> N;
	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������." << "\n";
	recur(N);

	return 0;
}