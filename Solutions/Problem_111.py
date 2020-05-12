'''
Question -->
This problem was asked by Google.
Given a word W and a string S, find all starting indices in S which are anagrams of W.
For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

Approach -->
Create a window of length equal to the length of the word.
In each iteration update the count of characters accordingly
'''

from collections import defaultdict


def findStartingIndices(string, word):

    charCount = defaultdict(int)
    count, strLen, wordLen = len(word), len(string), len(word)
    res = []

    # Initialise Dictionary
    for char in word:
        charCount[char] += 1

    # Create Window
    for idx in range(wordLen):
        char = string[idx]
        if charCount[char] > 0:
            count -= 1
        charCount[char] -= 1

    # If first window is an anagram add index 0 to result
    if count == 0:
        res.append(0)

    for idx in range(1, strLen-wordLen+1):

        outChar = string[idx-1]  # Character to be Excluded
        inChar = string[idx+wordLen-1]  # Character to be Included

        if outChar in charCount:         # If character is part of the word
            charCount[outChar] += 1      # Increment counter
            if charCount[outChar] > 0:
                count += 1

        if inChar in charCount:          # If character is part of the word
            if charCount[inChar] > 0:
                # charCount[inChar] < 0 when frequency[inChar] > required frequency in the window
                count -= 1
            charCount[inChar] -= 1

        if count == 0:
            res.append(idx)

    return res


string = "abxaba"
word = "ab"

print(*findStartingIndices(string, word))
