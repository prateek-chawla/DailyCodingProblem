def reverseWords(inp):
    i, j = 0, len(inp)-1
    lDelim, rDelim = ' ', ' '
    while(i <= j):
        # print("hello")
        if inp[i].isalpha() and inp[j].isalpha():
            i += 1
            j -= 1
        elif not inp[i].isalpha():
            while i <= j and not inp[i].isalpha():
                lDelim += inp[i]
                i += 1
        elif not inp[j].isalpha():
            while(j>=i and not inp[j].isalpha):
                rDelim += inp[j]
                j -= 1
        else:
            print(inp[i],inp[j])


inp = "hello/world:here"
reverseWords(inp)
