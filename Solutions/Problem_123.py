'''
Question -->
This problem was asked by LinkedIn.
Given a string, return whether it represents a number.
Here are the different kinds of numbers:

"10", a positive integer
"-10", a negative integer
"10.1", a positive real number
"-10.1", a negative real number
"1e5", a number in scientific notation
And here are examples of non-numbers:

"a"
"x 1"
"a -2"
"-"

Approach -->
Ensure that every e and decimal is followed by a digit.
Split the string into two parts before e and after e
Check for characters other than digits,'e' and '.'
and check for repetition
'''


def isNumber(inp):
    # Check if Empty
    if not inp:
        return False
    # Remove Sign
    inp = inp[1:] if inp[0] in ['-', '+'] else inp
    # Check if Empty
    if not inp:
        return False

    eFlag, decimalFlag, numFlag = False, False, False

    for i in range(len(inp)-1, -1, -1):
        if inp[i] == 'e' and not eFlag and numFlag:
            eFlag = True
            decimalFlag = False
            numFlag = False
        elif inp[i] == '.' and not decimalFlag and numFlag:
            decimalFlag = True
        elif inp[i].isdigit():
            numFlag = True
        else:
            return False

    return True


inp = '1e5'
print(isNumber(inp))
