'''
Question -->
This problem was asked by Google.
Given a string which we can delete at most k, return whether you
can make a palindrome.
For example, given 'waterrfetawx' and a k of 2, you could
delete f and x to get 'waterretaw'.

Approach -->
Initialise i with 0, j with last valid index of string
Check if character at i and j are equal, then they can form a
Palindrome else recurse by deleting a character from either end.
'''


def kPalindrome(inp, k, i, j):

    if i >= j and k >= 0:
        return True
    if k < 0:
        return False

    if inp[i] == inp[j]:
        return kPalindrome(inp, k, i+1, j-1)
    else:
        return kPalindrome(inp, i+1, j, k-1) or kPalindrome(inp, i, j-1, k-1)


inp = "waterretaw"
k = 2

print(kPalindrome(inp, k, 0, len(inp)-1))
