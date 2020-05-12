'''
Question -->
This problem was asked by Google.
Given a string of words delimited by spaces, reverse the words in string.
For example, given "hello world here", return "here world hello"
Follow-up: given a mutable string representation, can you perform this operation in-place?

Approach -->
Reverse individual words and then reverse the entire string
'''


def reverse(string, startIdx, endIdx):
    return string[startIdx:endIdx][::-1]


def reverseWords(inp):
    startIdx = 0
    endIdx = 0
    while endIdx < len(inp):
        if inp[endIdx] == ' ':
            inp[startIdx:endIdx] = reverse(inp, startIdx, endIdx)
            startIdx = endIdx+1
        endIdx += 1
    return reverse(inp, 0, len(inp))


inpString = "here world hello"
# Add Extra Whitespace in the end
inpString = inpString + ' '
inp = [c for c in inpString]

res = reverseWords(inp)
# Remove Whitespace that was added
res = ''.join(res[1:])

print(res)
