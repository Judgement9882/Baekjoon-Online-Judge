a = int(input())
b = input()
cal = int(b)
print(a)
print(b)
for i in range(len(b)):
    print(a*int(b[len(b)-i-1]))
    
print(a*cal)
