package com.kapil.array.find;

/**
 * Created by kapilsharma on 19/06/17.
 */

/**
 * Find the longest substring with k unique characters in a given string
 * <p>
 * <p>
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * <p>
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * <p>
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * <p>
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 */

public class LongSubstrUniChar {
    private static final int MAX_CHARS = 255;

    public static void main(String[] args) {
        String input = "allahabad";
        int k = 8;
        if (isPossible(input, k)) {
            findLongestStr(input, k);
        }
    }

    private static boolean isPossible(String input, int k) {
        int count[] = new int[MAX_CHARS];
        int unique = 0;
        for (int i = 1; i < input.length(); i++) {
            if (count[input.charAt(i) - 'a'] == 0) {
                unique++;
            }
            count[input.charAt(i) - 'a']++;
        }
        if (unique < k) {
            System.out.println("Not possible");
            return false;
        }
        return true;
    }

    private static boolean isValid(int count[], int k) {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count[i] > 0) {
                val++;
            }
        }
        return (k >= val);
    }

    private static void findLongestStr(String input, int k) {
        int start = 0, end = 0, windowSize = 1;
        int windowStart = 0;
        int count[] = new int[MAX_CHARS];
        count[input.charAt(0) - 'a']++;
        for (int i = 1; i < input.length(); i++) {
            count[input.charAt(i) - 'a']++;
            end++;
            while (!isValid(count, k)) {
                count[input.charAt(start) - 'a']--;
                start++;
            }
            if ((end - start + 1) > windowSize) {
                windowSize = end - start + 1;
                windowStart = start;
            }
        }
        System.out.println("Max Substring:" + input.substring(windowStart, windowSize) + " , windowSize:" + windowSize);

    }
}
