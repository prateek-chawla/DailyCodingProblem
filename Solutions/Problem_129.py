'''
Question -->
Given a real number n, find the square root of n.
For example, given n = 9, return 3.

Approach -->
Use Binary Search to find square root of the input number within
error limit of 10**-5
'''

ERROR_LIMIT = 10**-5


def squareRoot(n):
    if n == 1:
        return 1

    start = 0
    end = n

    while start <= n and end >= 0:
        mid = start+(end-start)/2
        midSquared = mid*mid

        if abs(n-midSquared) < ERROR_LIMIT:
            return mid
        if midSquared > n:
            end = mid-1
        else:
            start = mid+1


n = 10

sqRoot = round(squareRoot(abs(n)), 6)
if n < 0:
    print(sqRoot, "j", sep="")
else:
    print(sqRoot)
