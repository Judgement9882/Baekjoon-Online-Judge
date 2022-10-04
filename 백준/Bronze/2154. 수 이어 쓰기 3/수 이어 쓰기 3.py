N = int(input())
temp = ""
for i in range(1, N+1):
    temp = temp+str(i)
    
print(temp.find(str(N))+1)