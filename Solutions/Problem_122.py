'''
Question -->
This question was asked by Zillow.
You are given a 2-d matrix where each cell represents number
of coins in that cell. Assuming we start at matrix[0][0],
and can only move right or down, find the maximum number of
coins you can collect by the bottom right corner.

For example, in this matrix
0 3 1 1
2 0 0 4
1 5 3 1

The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

Approach -->
Maximise the number of coins by chosing the most profitable path using DP
'''


def isReachable(x, y):
    if 0 <= x < n and 0 <= y < m:
        return True
    return False


def calcMaxCoins(arr, n, m):
    dp = [[0 for j in range(m)] for i in range(n)]

    for i in range(n):
        for j in range(m):
            up = 0 if not isReachable(i-1, j) else dp[i-1][j]
            left = 0 if not isReachable(i, j-1) else dp[i][j-1]
            dp[i][j] = arr[i][j]+max(up, left)

    return dp[n-1][m-1]


arr = [[0, 3, 1, 1], [2, 0, 0, 4], [1, 5, 3, 1]]
n = len(arr)
m = len(arr[0])

print(calcMaxCoins(arr, n, m))
