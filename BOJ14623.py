# https://www.acmicpc.net/problem/14623

a = '0b' + input()
b = '0b' + input()

c = int(a, 2)
d = int(b, 2)

print(format(c*d, 'b'))
