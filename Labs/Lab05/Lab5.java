class Lab5 {

    public static void main(String[] args) {
        /* Camel case */ // assume valid string
        System.out.println("Camel Case");
        System.out.println("------------------------");

        System.out.println(camelCaseIterative("Hello World")); // hElLo wOrLd
        System.out.println(camelCaseRecursive("Hello World")); // hElLo wOrLd

        System.out.println(camelCaseIterative("Welcome to CS 2")); // wElCoMe tO cS 2
        System.out.println(camelCaseRecursive("Welcome to CS 2")); // wElCoMe tO cS 2
        System.out.println();

        /* Power */ // assume both inputs are >= 1
        // this function header is misleading, it is wrong in the sense of explanation
        // because lab is asking to raise the base 'b' to the power of 'n'; however the
        // lab has got params mixed in the code provided in the pdf, so i am going
        // to fix my implementation because you had f(n_power,base) produce n_power ^
        // base and even though the the output is correct the function design isn't
        // if you do not believe me, you can ask to check the pdf that i got from y'all.
        // thx!

        System.out.println("Power");
        System.out.println("------------------------");

        System.out.println(powerNIterative(3, 1)); // 3
        System.out.println(powerNRecursive(3, 1)); // 3

        System.out.println(powerNIterative(3, 2)); // 9
        System.out.println(powerNRecursive(3, 2)); // 9
        System.out.println();

        /* String Clean */
        // adjacent chars are minimized to 1 if they are the same
        System.out.println("String Clean");
        System.out.println("------------------------");

        System.out.println(stringCleanIterative("abbbcdd")); // abcd
        System.out.println(stringCleanRecursive("abbbcdd")); // abcd

        System.out.println(stringCleanIterative("Hello")); // Helo
        System.out.println(stringCleanRecursive("Hello")); // Helo
        System.out.println();

        /* All Star */
        // add star * to separate adjacent characters
        System.out.println("All Star");
        System.out.println("------------------------");

        System.out.println(allStarIterative("hello")); // h*e*l*l*o
        System.out.println(allStarRecursive("hello")); // h*e*l*l*o

        System.out.println(allStarIterative("abc")); // a*b*c
        System.out.println(allStarRecursive("abc")); // a*b*c
        System.out.println();

        /* Count Hi */
        System.out.println("Count Hi");
        System.out.println("------------------------");

        System.out.println(countHiIterative("xxhixx")); // 1
        System.out.println(countHiRecursive("xxhixx")); // 1

        System.out.println(countHiIterative("xhixhix")); // 2
        System.out.println(countHiRecursive("xhixhix")); // 2

    }

    public static String camelCaseIterative(String w) {
        String output_string = "";
        boolean isCapital = false;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == ' ' || Character.isDigit(w.charAt(i))) {
                output_string += w.charAt(i);
                // lab mentioned that numbers and spaces are ignored, but if that were the case
                // then we would output hElLo WoRlD;
                // since lab want my output to match labs, the function needs to reset to
                // starting camel case again after a number or a blank space
                isCapital = false;
                continue;
            }
            if (isCapital) {
                // add upper case and change the boolean flag for next time
                output_string += Character.toUpperCase(w.charAt(i));
                isCapital = false;

            } else {
                // add lower case and change the boolean flag for next time
                output_string += Character.toLowerCase(w.charAt(i));
                isCapital = true;
            }

        }
        return output_string;
    }

    public static boolean camel_case_first_recursion = true;

    public static String camelCaseRecursive(String w) {
        if (w.length() <= 1) {
            // we have one character or none // base case
            camel_case_first_recursion = true;
            return w;
        }

        if (w.charAt(0) == ' ' | Character.isDigit(w.charAt(0))) {
            // if character is space or number -> w take the space, make the rest lower to
            // achieve your requested output by the other recursive case
            return w.charAt(0) + camelCaseRecursive(w.substring(1).toLowerCase());
        }

        // if it is the first time and its a character no matter if its upper or lower
        // make it lower and recurse on upper rest
        if (camel_case_first_recursion) {
            camel_case_first_recursion = false;
            return Character.toLowerCase(w.charAt(0)) + camelCaseRecursive(w.substring(1).toUpperCase());
        }

        // if we start with a small character then we use it and take the remaining,
        // make them upper and pass them
        if (Character.isLowerCase(w.charAt(0))) {
            return w.charAt(0) + camelCaseRecursive(w.substring(1).toUpperCase());
        }

        // if we have not returned by now, it means that the first is upper, we take it
        // and return the rest on lower
        return w.charAt(0) + camelCaseRecursive(w.substring(1).toLowerCase());

    }

    public static int powerNIterative(int b, int n) {
        // decrementing n until we have it equal 0 because when exp is 0 the base is 1
        while (n > 1) {
            b *= b;
            n--;
        }

        return b;
    }

    public static int powerNRecursive(int b, int n) {
        // decrementing n until we have it equal 0 because when exp is 0 the base is 1
        if (n < 1) {
            return 1;
        }
        return b * powerNRecursive(b, n - 1);
    }

    public static String stringCleanIterative(String w) {
        String output = "";
        boolean seen = false;

        for (int i = 0; i < w.length(); i++) {
            if (seen == false) {
                output += w.charAt(i);
            }

            if ((i + 1) < w.length()) {
                if (w.charAt(i) == w.charAt(i + 1)) {
                    seen = true;
                } else {
                    seen = false;
                }
            }

        }

        return output;
    }

    public static String stringCleanRecursive(String w) {
        // base case : only 1 left
        if (w.length() <= 1) {
            return w;
        }

        // we will do a terniary operation wheter the two adjacents are the same, if
        // they are we discard the first and continue on the rest on the string
        return (w.charAt(0) != w.charAt(1)) ? w.charAt(0) + stringCleanRecursive(w.substring(1))
                : stringCleanRecursive(w.substring(1));
    }

    public static String allStarIterative(String w) {
        String output = "";
        for (int i = 0; i < w.length() - 1; i++) {
            output += w.charAt(i);
            output += '*';
        }
        output += w.charAt(w.length() - 1);
        return output;
    }

    public static String allStarRecursive(String w) {
        // base case when only one char left
        if (w.length() <= 1) {
            return w;
        }

        // give first character followed by * for adjacency separation
        return w.charAt(0) + "*" + allStarRecursive(w.substring(1));
    }

    public static int countHiIterative(String w) {
        int count = 0;
        int i = 0;
        while (i < w.length()) {
            if ((i + 1) < w.length() && Character.toLowerCase(w.charAt(i)) == 'h'
                    && Character.toLowerCase(w.charAt(i + 1)) == 'i') {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }

    public static int countHiRecursive(String w) {
        // if we have less than 2 characters, then there is no match
        if (w.length() <= 1) {
            return 0;
        }

        // if we have at least two characters we check for a match at each function copy
        // if we find it we accumulate 1 and recurse starting from the next character
        // after 'i' else if we did not find a match we start again at the next char
        return (w.charAt(0) == 'h' && w.charAt(1) == 'i') ? 1 + countHiRecursive(w.substring(2))
                : countHiRecursive(w.substring(1));
    }
}