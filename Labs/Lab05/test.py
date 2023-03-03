def alternate_case(s):
    # Base case: if the string is empty or has only one character, return it as is
    if len(s) <= 1:
        return s

    # Recursive case: alternate the case of the first character and recursively call the function on the rest of the string
    if len(s) % 2 == 0:  # if the length of the string is even
        return s[0].lower() + alternate_case(s[1:]).upper()
    else:  # if the length of the string is odd
        return s[0].upper() + alternate_case(s[1:]).lower()


if __name__ == "__main__":
    print(alternate_case("Hello World"))
