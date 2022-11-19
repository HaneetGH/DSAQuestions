package com.technorapper.dsaquestions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ListRelated {


    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            integerList.add(i);
        integerList.add(0, 88); // Add item at zero and lift other one step up
        integerList.set(0, 99); // update value of 0 index
        //System.out.println(integerList);
        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        minOperation(arr, arr.length);
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 30, 2));
        list.add(Arrays.asList(31, 60, 4));
        list.add(Arrays.asList(61, 120, 3));
        list.add(Arrays.asList(1, 20, 2));
        list.add(Arrays.asList(21, 40, 4));
        list.add(Arrays.asList(41, 60, 5));
        list.add(Arrays.asList(61, 120, 3));
        list.add(Arrays.asList(1, 60, 4));
        list.add(Arrays.asList(61, 120, 4));
        maxBandwith(list,3);
    }

    public static int minOperation(int arr[], int n) {
        // Insert all elements in hash.
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
            if (hash.containsKey(arr[i])) hash.put(arr[i], hash.get(arr[i]) + 1);
            else hash.put(arr[i], 1);

        // find the max frequency
        int max_count = 0;
        Set<Integer> s = hash.keySet();

        for (int i : s)
            if (max_count < hash.get(i)) max_count = hash.get(i);

        // return result
        return (n - max_count);
    }

    static void test() {
        int i = 0;
        int sum = 0;
        while (i < 100) {
            sum = sum + 1;
            sum = i + sum;
            i += 1;
        }
        System.out.println(sum);
    }

    static void printMinOp(int arr[]) {
        int arraySum, smallest, arr_size = arr.length;
        arraySum = 0;
        smallest = arr[0];
        for (int i = 0; i < arr_size; i++) {
            // If current element is smaller than update smallest
            if (arr[i] < smallest) smallest = arr[i];

            // find array sum
            arraySum += arr[i];
        }

        int minOperation = arraySum - arr_size * smallest;

        // Print min operation required
        System.out.println("Minimum Operation = " + minOperation);
    }

    static int minimumOperations(int arr[], int n) {
        int i;

        // It will count total no. of operations
        int operations = 0;

        for (i = 0; i < n - 1; i++) {

            // Calculate the difference and
            // add its absolute value to
            // the no. of operations
            operations += Math.abs(arr[i + 1] - arr[i]);

            // If the changes are done in prefix
            // then update first element of array
            if (arr[i + 1] - arr[i] < 0) {
                arr[0] -= (Math.abs(arr[i + 1] - arr[i]));
            }
        }

        // Now all the elements of the array are
        // equal to arr[0], add absolute value
        // of arr[0] to the no. of operations
        operations += Math.abs(arr[0]);

        // Return the total number of operations
        return operations;
    }

    public static int maxBandwith(List<List<Integer>> list, int n) {
        int[] req = new int[n];
        for (List<Integer> item1 : list) {
            for (int i = 0; i < n; i++) {
                if (req[i] < item1.get(2)) {
                    req[i] = item1.get(2);
                    break;
                }
            }
        }


        int sum = 0;
        for (int i : req) {
            sum += i;
        }
        return sum;
    }
}
