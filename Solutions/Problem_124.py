'''
Question -->
This problem was asked by Microsoft.
You have n fair coins and you flip them all at the same time.
Any that come up tails you set aside.
The ones that come up heads you flip again.
How many rounds do you expect to play before only one coin remains?

Write a function that, given n, returns the
number of rounds you'd expect to play until one coin remains.

Approach -->
Probability of getting heads or tails is 0.5
After each round half of the coins are removed.
'''

from math import ceil, log2


def calcRounds(n):
    return ceil(log2(n))


n = 8
print(calcRounds(n))
