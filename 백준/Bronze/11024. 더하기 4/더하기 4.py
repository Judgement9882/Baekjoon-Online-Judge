T = int(input())
for i in range(T):
  str = input().split(" ")
  ans = 0
  for i in str:
    ans = ans + int(i)
  print(ans)