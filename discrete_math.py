def permutation(n, r):
    return factorial(n) / factorial(n - r)


def circular_permutation(r):
    return factorial(r-1)


def combination(n, r):
    return factorial(n)/(factorial(r)*factorial(n-r))

def permutationRepetition(n, r):
    return factorial(n) / factorial(r)


def factorial(n):
    if n == 1:
        return 1
    else:
        return factorial(n - 1) * n


def print_multiplication(start, end, end2):
    for i in range(start, end, -1):
        sign = 'x'
        if i == end2:
            sign = ""

        print(i, end=sign)

def create_combination_formula(n, r):
    print("C(n, r)=",(3, 2),"\t")
    print("\t\t=\t", n,"!")
    print("\t\t_____________")
    print("\t\t",r,"!(",n,"-",r,")!")
    print("\t\t=\t",n,"!")
    print("\t\t_____________")
    print("\t\t", r, "!", n-r, "!")


def createFormula_permutationRepetition(n, r):
    print("r = P(", n, r, ") =", n, "!")
    print("\t\t\t_____________")
    print("\t\t\t  ", r, '!')
    print("\t\t\t=", end="")

    print_multiplication(n, r-1, r)

    print("!")
    print("\t\t\t_____________")
    print("\t\t\t  ", r, '!')
    print("\t\t\t=", end="")

    print_multiplication(n, r, r+1)


def createFormula_permutation(n, r):
    diff = n - r
    print("P(", n, r, ") =  ", n, "!")
    print("\t\t_____________")
    print("\t\t (", n, "-", r, ")!")
    print()
    print("\t\t=\t", n, "!")
    print("\t\t_____________")
    print("\t\t\t", diff, "!")
    print("\t\t=\t", end="")

    print_multiplication(n, diff - 1, diff)

    print("!")
    print("\t\t_____________")
    print("\t\t\t", n - r, "!")


def computePermutation(n, r):
    if r > n:
        print("Invalid syntax")
    else:
        createFormula_permutation(n, r)
        print()
        print("\t\t\t=", end="")
        print(int(permutation(n, r)), "permutation of", n, "object taken", r, "at a time")


def circular_permutation_formula(r):
    print("h =(",r,"-1)!")
    print("  =",r-1,"!")
    print("  =",end=" ")
    print_multiplication(r-1, 0, 1)



def computePermutationRepetition(n, r):
    if r > n:
        print("Invalid syntax")
    else:
        createFormula_permutationRepetition(n, r)
        print()
        print("\t\t\t=", end="")
        print(int(permutationRepetition(n, r)), "permutation with repetition of", n, "object taken", r, "at a time")


def compute_permutation_combination(n, r):
    if r > n:
        print("Invalid syntax")
    else:
        create_combination_formula(n, r)
        print()
        print("\t\t\t=", end="")
        print(int(combination(n, r)), "permutation with repetition of", n, "object taken", r, "at a time")


def compute_permutation_combination(r):

        circular_permutation_formula(r)
        print()
        print("  =", end="")
        print(int(circular_permutation(r)), "ways of arranging", r, "object around the table")


print("Select Topic")
print()

print("1. Permutation")
print("2. Permutation with repetition")
print("3. Combination")
print("4. Circular Permutation")
option = int(input("Select:"))

if option == 1:
    n = int(input("Enter n: "))
    r = int(input("Enter r: "))
    computePermutation(n, r)
elif option == 2:
    n = int(input("Enter n: "))
    r = int(input("Enter r: "))
    computePermutationRepetition(n, r)
elif option == 3:
    n = int(input("Enter n: "))
    r = int(input("Enter r: "))
    combination(n, r)
elif option == 4:
    r = int(input("Enter r: "))
    compute_permutation_combination(r)
else:
    print("invalid Option")
