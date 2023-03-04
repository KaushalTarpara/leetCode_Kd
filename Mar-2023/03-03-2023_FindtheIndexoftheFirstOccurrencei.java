// Find the Index of the First Occurrence in a String
// Medium
// 1.7K
// 115
// Companies
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

// Constraints:

// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.

class 03-03-2023_FindtheIndexoftheFirstOccurrencei {
    public static int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
        return 0;
    }
    int haystackLen = haystack.length();
    int needleLen = needle.length();
    if (haystackLen < needleLen) {
        return -1;
    }
    for (int i = 0; i <= haystackLen - needleLen; i++) {
        int j;
        for (j = 0; j < needleLen; j++) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                break;
            }
        }
        if (j == needleLen) {
            return i;
        }
    }
    return -1;
}

}