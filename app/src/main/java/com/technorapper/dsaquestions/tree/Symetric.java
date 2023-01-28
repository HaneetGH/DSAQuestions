package com.technorapper.dsaquestions.tree;

import com.technorapper.dsaquestions.linklist.TreeNode;

public class Symetric {
    public static boolean isSymmetric(TreeNode root) {
        return (root == null || helper(root.left, root.right));

    }

    public static boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }

    public static void main(String args[]) {


        int[] array = {1, 2, 2, 3, 4, 4, 3};
        TreeNode node = insertLevelOrder(array, 0);
        isSymmetric(node);

    }

    public static  TreeNode insertLevelOrder(int[] arr, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
}
