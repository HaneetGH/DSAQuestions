package com.technorapper.dsaquestions.graph;

import java.util.Arrays;
import java.util.Collections;

public class DFS {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 4, 5}, arr2 = {2, 4, 6, 8};


    //    System.out.print(joinsortedList(arr1, arr2));

        System.out.println(findFirstBadVersion(new int[]{0,1,2,3,4}));
    }


    public static int[] joinsortedList(int[] arrayOne, int[] arrayTwo) {
        int m = arrayOne.length;
        int n = arrayTwo.length;
        int i = m - 1;
        int j = n - 1;
        int[] newArray = new int[m + n];
        while (i >= 0 && j >= 0) {
            if (arrayOne[i] >= arrayTwo[j]) {
                newArray[i + j + 1] = arrayOne[i];
                i--;
            } else {
                newArray[i + j + 1] = arrayTwo[j];
                j--;
            }
        }

        while (i >= 0) {
            newArray[i + j + 1] = arrayOne[i];
            i--;
        }
        while (j >= 0) {
            newArray[i + j + 1] = arrayTwo[j];
            j--;
        }
        return newArray;
    }


    /*
    * Suppose in a company, one product manager is leading a team who develops a new product. Suppose latest version fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version will be bad. So we have an array A with n elements [1, 2, … n] and we have to find the first bad version from this array.
Consider we have a function isBadVersion(version_id), this will return whether the version is bad or not.*/
    public static int findFirstBadVersion(int[] versionID) {
        int start = 0;
        int end = versionID.length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }

            if (isBadVersion(start)) {
                return start;
            }
        }
        return end;
    }

    private static boolean isBadVersion(int mid) {
        Boolean[] array = new Boolean[]{true, false, false, false, false};
        return array[mid];
    }


}
