def cal(i, jin):
    sum = 0
    while i > 0:
        sum += i % jin
        i = i // jin
    return sum

for i in range(1000, 10000):
    ten = cal(i, 10)
    two = cal(i, 12)
    six = cal(i, 16)
    
    if ten == two and ten == six:
        print(i)
