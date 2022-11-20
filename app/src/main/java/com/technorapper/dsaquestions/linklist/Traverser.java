package com.technorapper.dsaquestions.linklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traverser {
    static TreeNode node;

    public static void main(String[] args) {
        node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);

        //inorderTraversal(node);
        //inorderTraversal1(node);
        //inorderTraversalMy(node);
        postorderTraversal(node);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !treeNodeStack.isEmpty()) {

            while (cur != null) {
                treeNodeStack.add(cur);
                cur = cur.left;
            }
            cur = treeNodeStack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }

    public static List<Integer> inorderTraversalMy(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        while (root != null) {
            result.add(root.val);
            if (root.left != null) {
                root = root.left;
            }
            if (root.right != null) {
                root = root.right;
            }

        }

        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);

            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }

        return ans;
    }

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return ans;

        postorderTraversal(root.left);
        ans.add(root.val);
        postorderTraversal(root.right);

        return ans;


    }

    List<List<Integer>> anss = new ArrayList<>();

    public List<List<Integer>> levelOrder(NArrayTree root) {

        Queue<NArrayTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            List<Integer> level = new ArrayList<>();
            while (sizeOfQueue-- > 0) {
                NArrayTree cur = queue.poll();
                level.add(cur.val);
                for (NArrayTree child : cur.children) {
                    queue.add(child);
                }
            }
            anss.add(new ArrayList<>(level));
        }


        return anss;
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }


}

