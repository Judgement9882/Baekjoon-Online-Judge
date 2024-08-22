num = int(input())
if num == 1 or num == 2:
  print(1)
else:
  first = 1
  second = 1
  for i in range(num-2):
    temp = second
    second += first
    first = temp
  print(second)