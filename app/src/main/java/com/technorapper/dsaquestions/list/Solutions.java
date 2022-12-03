package com.technorapper.dsaquestions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solutions {

    public static void main(String[] args) {
        //lengthOfLongestSubstring("tmmzuxt");
        // longestPalindrome("bb");
        int[] nums1 = {1, 3}, nums2 = {2};
        findMedianSortedArrays(nums1, nums2);

    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.trim().isEmpty()) return 0;
        if (s.equals(" ")) return 1;
        if (s.length() == 1) return 1;
        char[] charArray = s.toCharArray();
        String newString = "";
        int maxCount = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (newString.indexOf(charArray[i]) == -1) {

                newString += charArray[i];
                if (newString.length() > maxCount)
                    maxCount = newString.length();
            } else {
                if (newString.length() > maxCount)
                    maxCount = newString.length();
                newString = newString.substring(newString.indexOf(charArray[i]) + 1);
                newString += charArray[i];
            }
        }

        return maxCount;
    }

    public static String longestPalindrome(String s) {
        int count = 0;
        String resultString = "";
        for (int k = 0; k < s.length(); k++) {
            for (int j = k; j <= s.length(); j++) {
                String str = s.substring(k, j);
                if (isPalindrome(str)) {
                    if (str.length() > count) {
                        count = str.length();
                        resultString = str;
                    }
                }

            }
        }
        return resultString;
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedJoinArray = new int[nums1.length + nums2.length];

        int largestInt = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < largestInt; i++) {

            sortedJoinArray[i] = Math.min(nums1[i], nums2.length>i?nums2[i]:nums1[i]);
            if ((i + 1) < largestInt)
                sortedJoinArray[i+1] = Math.max(nums1[i], nums2.length>i?nums2[i]:nums1[i]);

        }

        return 0;

    }
}
