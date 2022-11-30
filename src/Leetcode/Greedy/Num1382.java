package Leetcode.Greedy;


import java.util.ArrayList;
import java.util.List;

public class Num1382 {
    void dfs(TreeNode root, List<TreeNode> node) {
        if (root == null) return;
        dfs(root.left, node);
        node.add(root);
        dfs(root.right, node);

    }

    TreeNode helper(ArrayList<TreeNode> nodes, int start, int end) {
        if (start > end) { // Base case.
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = nodes.get(mid); // Add the root as the middle of nodes.

        node.left = helper(nodes, start, mid - 1); // Recursively call the same method with the left side of the array, and assign it to the left of the root.
        node.right = helper(nodes, mid + 1, end); // Recursively call the same method with the right side of the array, and assign it to the right of the root.

        return node; // Return the current TreeNode to your previous caller.
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> node = new ArrayList<>();
        dfs(root, node);

        int n = node.size();
        return helper(node, 0, n - 1);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
/*
    public static void insert_node(TreeNode root, int val) {
        if (root == null)
            root.val = val;
        else {
            TreeNode head = root;
            TreeNode CurrentNode = head;
            while (true) {
                CurrentNode = head;
                if (root.val >= val) {
                    head = head.left;
                    if (head == null) {
                        CurrentNode.left.val = val;
                        break;
                    }
                } else {
                    head = head.right;
                    if (head == null) {
                        CurrentNode.right.val = val;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 10;
        insert_node(root, 5);
        insert_node(root, 16);
        insert_node(root, 3);
        insert_node(root, 7);
        insert_node(root, 18);

        
        System.out.println();

    }*/


}
