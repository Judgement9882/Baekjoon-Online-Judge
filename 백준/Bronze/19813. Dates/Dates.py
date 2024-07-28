T = int(input())
for i in range(T):
  str = input()
  if str.find('.') != -1:
    [day, month, year] = str.split('.')
    day = int(day)
    month = int(month)
    year = int(year)
    print("%02d" % day + "." + "%02d" % month + "." + "%04d" % year, end = ' ')
    print("%02d" % month + "/" + "%02d" % day + "/" + "%04d" % year)
  else:
    [month, day, year] = str.split('/')
    month = int(month)
    day = int(day)
    year = int(year)
    print("%02d" % day + "." + "%02d" % month + "." + "%04d" % year, end = ' ')
    print("%02d" % month + "/" + "%02d" % day + "/" + "%04d" % year)