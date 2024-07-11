T = int(input())
for i in range(T):
  str = input().strip()
  check = True
  for j in range(len(str)):
    if str[j] < '0' or str[j] > '9':
      check = False
      break
  if len(str)==0: # all blank
    check = False
  if check:
    print(int(str))
  else:
    print("invalid input")