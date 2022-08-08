def fibonacci(n):
    if n <=1:
        return n
    else:
        return fibonacci(n-1)+fibonacci(n-2)


def lucas_number(n):
    if n==0:
        return 2
    elif n==1:
        return 1
    else:
        return lucas_number(n-1)+ lucas_number(n-2)


def tribonacci(n):
    if n<=1:
        return 0
    elif n<=2:
        return 1
    else:
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3)


def print_fibonacci(start, end):

    for i in range(end+1):
        fibo = fibonacci(i)
        if fibo >= start:
            if i <= 1:
                print("F", i, "=", i)
            else:
                print("F", i, "=F(", i, "-1)+F(", i, "-2)=", fibonacci(i - 1), "+", fibonacci(i - 2), "=", end=" ")
                print(fibonacci(i))


def print_lucas_number(start, end):

    for i in range(end+1):
        lucas = lucas_number(i)
        if lucas >= start:
            if i <= 1:
                print("L", i, "=", 2-i)

            else:
                print("L", i, "=L(", i, "-1)+L(", i, "-2)=", lucas_number(i - 1), "+", lucas_number(i - 2), "=", end=" ")
                print(lucas_number(i))


def print_tribonacci(start, end):

    for i in range(end+1):
        tribo = tribonacci(i)
        if tribo >= start:
            if i <=1:
                print("T", i, "=0")

            elif i<=2:
                print("T", i, "=1")

            else:
                print("T", i, "=T(", i, "-1)+T(", i, "-2)","+T(", i, "-3)=",  tribonacci(i - 1), "+", tribonacci(i - 2),"+", tribonacci(i - 3), "=", end=" ")
                print(tribonacci(i))


start = int(input("Enter Start: "))
end = int(input("Enter End:"))


if start>end:
    print("Invalid input")
else:
    print("____________________________")
    print("1. Fibonacci")
    print("2. Lucas Number")
    print("3. Tribonacci")
    print("Select topic: ", end="")
    select = int(input())
    print()

    if select ==1:
        print_fibonacci(start, end)
    elif select==2:
        print_lucas_number(start, end)
    elif select == 3:
        print_tribonacci(start, end)
